package com.rest.controller;

import com.rest.service.MarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/mars")
public class MarsController {

    @Autowired
    private MarsService service;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/{command}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String comandar(@Valid @NotNull @PathVariable String command) {
        return service.command(command);
    }
}
