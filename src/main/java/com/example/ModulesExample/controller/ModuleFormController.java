package com.example.ModulesExample.controller;

import com.example.ModulesExample.entity.Module;
import com.example.ModulesExample.service.ModuleService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
@RequestMapping("/api/v1/module")
public class ModuleFormController {

    @Autowired
    ModuleService moduleService;

    @GetMapping("/add-module")
    public String moduleForm(Model model) {
        List<Module> allModules = moduleService.getAllModules();

        model.addAttribute("pModule", new Module());
        model.addAttribute("allModules", allModules);
        return "module";
    }

    @PostMapping("/add-module")
    public String moduleSubmit(@Valid @NotNull @NotBlank @ModelAttribute("pModule") Module module, Model model) {

        model.addAttribute("pModule", module);

        if (module.getParentModule() != null) {
            module.setDepth(module.getParentModule().getDepth() + 1);
            if (module.getDepth() > 2) {
                return "error";
            }
        }
        moduleService.saveModule(module);
        return "result";
    }

}
