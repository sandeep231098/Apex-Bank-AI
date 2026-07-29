package com.apexbank.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CurrentUserService {

    private Jwt getJwt() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null ||
                !(authentication.getPrincipal() instanceof Jwt jwt)) {

            throw new IllegalStateException("No authenticated user found");
        }

        return jwt;
    }

    public String getSubject() {
        return getJwt().getSubject();
    }

    public String getUsername() {
        return getJwt().getClaimAsString("preferred_username");
    }

    public String getEmail() {
        return getJwt().getClaimAsString("email");
    }

    public String getFirstName() {
        return getJwt().getClaimAsString("given_name");
    }

    public String getLastName() {
        return getJwt().getClaimAsString("family_name");
    }

    public List<String> getRoles() {

        Jwt jwt = getJwt();

        Object realmAccess = jwt.getClaim("realm_access");

        if (!(realmAccess instanceof java.util.Map<?, ?> realmMap)) {
            return Collections.emptyList();
        }

        Object roles = realmMap.get("roles");

        if (!(roles instanceof List<?> roleList)) {
            return Collections.emptyList();
        }

        return roleList.stream()
                .map(Object::toString)
                .toList();
    }

    public boolean hasRole(String role) {
        return getRoles().contains(role);
    }

}