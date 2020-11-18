package com.example.ModulesExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class VisualiseController {

    @RequestMapping("/api/v1/module/visualize/{id}")
    public String selectModuleToVisualise(@PathVariable String id) {
        return "jsonVisualizer";
    }
}
