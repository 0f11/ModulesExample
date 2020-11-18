package com.example.ModulesExample.service;

import com.example.ModulesExample.ModuleDTO.ModuleDTO;
import com.example.ModulesExample.entity.Module;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ModuleService {
    ResponseEntity<ModuleDTO> findById(Long id);
    List<Module> getAllModules();
    void saveModule(Module module);
}
