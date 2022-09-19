package com.perekupapp.controllers;

import com.perekupapp.services.Manager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @GetMapping("go-debug")
    public String goDebug() {
        return Manager.goDebug();
    }
}