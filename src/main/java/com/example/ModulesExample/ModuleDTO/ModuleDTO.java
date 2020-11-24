package com.example.ModulesExample.ModuleDTO;

import com.example.ModulesExample.entity.Module;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
@Builder
public class ModuleDTO {
    private Long id;
    private String name;
    private List<Module> children;
}
