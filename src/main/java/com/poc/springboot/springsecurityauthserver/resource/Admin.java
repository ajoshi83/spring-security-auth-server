package com.poc.springboot.springsecurityauthserver.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("admin")
@Validated
public class Admin {
    @Autowired
    private TokenStore tokenStore;

    @GetMapping("/token/list")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_ADMIN"})
    public List<String> findAllTokens() {
        final Collection<OAuth2AccessToken> tokensByClientId = tokenStore.findTokensByClientId("my-client");
        return tokensByClientId.stream().map(token -> token.getValue()).collect(Collectors.toList());
    }
}
