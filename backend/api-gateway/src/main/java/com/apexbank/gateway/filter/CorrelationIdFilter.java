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
public class CorrelationIdFilter implements GlobalFilter, Ordered {

    public static final String CORRELATION_ID = "X-Correlation-Id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        String correlationId =
                request.getHeaders().getFirst(CORRELATION_ID);

        if (!StringUtils.hasText(correlationId)) {

            correlationId = UUID.randomUUID().toString();

            request = request.mutate()
                    .header(CORRELATION_ID, correlationId)
                    .build();
        }

        exchange.getAttributes().put(CORRELATION_ID, correlationId);

        log.info("CorrelationId : {}", correlationId);

        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return -2;
    }
}