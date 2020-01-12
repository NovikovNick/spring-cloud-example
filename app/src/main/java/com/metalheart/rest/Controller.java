package com.metalheart.rest;

import com.metalheart.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    @Value("${user.role}")
    private String role;


    @GetMapping
    public Response get() {
        return Response.builder().payload("success: " + role).build();
    }
}
