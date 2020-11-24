package com.example.ModulesExample.service;

import com.example.ModulesExample.ModuleDTO.ModuleDTO;
import com.example.ModulesExample.entity.Module;
import com.example.ModulesExample.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;


@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    private final Function<Module, ModuleDTO> mapToDTO = m -> ModuleDTO.builder()
            .id(m.getId())
            .name(m.getName())
            .depth(m.getDepth())
            .children(m.getChildren())
            .build();

    @Override
    public ResponseEntity<ModuleDTO> findById(Long id) {
        return moduleRepository.findById(id).map(mapToDTO).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public void saveModule(Module module) {
        moduleRepository.save(module);
    }

}
