package com.example.ModulesExample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Module {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Min(0)
    @Max(2)
    private int depth;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Module parentModule;

    @OneToMany(mappedBy = "parentModule",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @Setter
    @Getter
    private List<Module> children;

}
