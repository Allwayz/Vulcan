package com.vulcan.model.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.Prescription;
import com.vulcan.model.mapper.PrescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Allwayz
 * @since 2020-04-04
 */
@Transactional
@RestController
@RequestMapping("/prescription")
public class PrescriptionController extends ApiController {
    @Autowired
    private PrescriptionMapper prescriptionMapper;

    @GetMapping()
    public R getPrescription(){
        Prescription prescription;
        return null;
    }

    @PostMapping()
    public R addPrescription(String medicineName,int count){

        return null;
    }
}
