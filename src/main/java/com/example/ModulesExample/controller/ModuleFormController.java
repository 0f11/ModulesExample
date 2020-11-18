package com.example.ModulesExample.controller;

import com.example.ModulesExample.entity.Module;
import com.example.ModulesExample.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/module")
public class ModuleFormController {

    @Autowired
    ModuleService moduleService;

    @GetMapping("/add-module")
    public String moduleForm(Model model){
        List<Module> allModules = moduleService.getAllModules();

        model.addAttribute("module", new Module());
        model.addAttribute("allmodules", allModules);
        return "module";
    }
    @PostMapping("/add-module")
    public String moduleSubmit(@ModelAttribute("module") Module module, @ModelAttribute("allmodules") Module selectedModule, Model model){
        model.addAttribute("module", module);
        if (module.getParentModule() != null){
            module.setDepth(module.getParentModule().getDepth()+1);
            if (module.getDepth() > 2){
                return "error";
            }
        }
        moduleService.saveModule(module);
        return "result";
    }

}
