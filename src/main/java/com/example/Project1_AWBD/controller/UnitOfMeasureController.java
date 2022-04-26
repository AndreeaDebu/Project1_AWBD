package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.UnitOfMeasure;
import com.example.Project1_AWBD.services.UnitOfMeasureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit-of-measure")
@AllArgsConstructor
public class UnitOfMeasureController {
    private final UnitOfMeasureService unitOfMeasureService;

    @PostMapping("/add")
    public UnitOfMeasure add(UnitOfMeasure unitOfMeasure){
        unitOfMeasure.setUnitOfMeasure("kg");
        return unitOfMeasureService.save(unitOfMeasure);
    }

}
