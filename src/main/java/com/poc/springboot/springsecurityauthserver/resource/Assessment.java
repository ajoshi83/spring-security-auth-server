package com.poc.springboot.springsecurityauthserver.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api")
@Validated
public class Assessment {

    @PostMapping(path="/v1/assessment", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_ADMIN"})
    public String createAssessment(Principal principal) {
        return String.format("Hi %s, you are allowed to create Assessment", principal.getName());
    }

    @GetMapping("/v1/assessments")
    @ResponseStatus(HttpStatus.OK)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String viewAssessment(Principal principal) {
        return String.format("Hi %s, you are allowed to view Assessments", principal.getName());
    }
}
