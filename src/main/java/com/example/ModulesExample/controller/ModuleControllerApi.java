package com.example.ModulesExample.controller;

import com.example.ModulesExample.ModuleDTO.ModuleDTO;

import com.example.ModulesExample.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/module")
public class ModuleControllerApi {

    @Autowired
    ModuleService moduleService;

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> getModulesId(@PathVariable("id") Long id) {
        return moduleService.findById(id);
    }
}

