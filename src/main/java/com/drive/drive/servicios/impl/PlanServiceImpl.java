package com.drive.drive.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.drive.modelos.Plan;
import com.drive.drive.repositorios.PlanRepository;
import com.drive.drive.servicios.PlanService;
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;
    @Override
    public Plan crearPlan(Plan plan) {
       return planRepository.save(plan);
    }
    
    
}
