package com.apexbank.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Component
public class GlobalLoggingFilter implements GlobalFilter, Ordered {

    public static final String REQUEST_ID = "X-Request-Id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        String requestId = request.getHeaders().getFirst(REQUEST_ID);

        if (!StringUtils.hasText(requestId)) {
            requestId = UUID.randomUUID().toString();

            request = request.mutate()
                    .header(REQUEST_ID, requestId)
                    .build();
        }

        long startTime = System.currentTimeMillis();

        log.info(
                "[{}] {} {}",
                requestId,
                request.getMethod(),
                request.getURI()
        );

        String finalRequestId = requestId;

        return chain.filter(exchange.mutate().request(request).build())
                .doFinally(signal -> {

                    long duration = System.currentTimeMillis() - startTime;

                    log.info(
                            "[{}] Completed in {} ms",
                            finalRequestId,
                            duration
                    );
                });
    }

    @Override
    public int getOrder() {
        return -1;
    }
}