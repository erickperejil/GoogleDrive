package com.drive.drive.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.drive.drive.modelos.Plan;
import com.drive.drive.servicios.impl.PlanServiceImpl;

@RestController
@RequestMapping("api/plan")
public class PlanController {
    @Autowired
    private PlanServiceImpl planServiceImpl;
    @PostMapping("/crear")
    public Plan crearPlan(@RequestBody Plan nvoPlan){
        return this.planServiceImpl.crearPlan(nvoPlan);
    }

}
