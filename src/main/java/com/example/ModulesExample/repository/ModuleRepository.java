package com.example.ModulesExample.repository;

import com.example.ModulesExample.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

}

