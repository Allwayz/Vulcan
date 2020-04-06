package com.vulcan.model.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.MedicalReport;
import com.vulcan.model.mapper.MedicalReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/medical-report")
public class MedicalReportController extends ApiController {
    @Autowired
    private MedicalReportMapper medicalReportMapper;

    /**
     * <p>
     *     对就诊新建一个回执单
     *     逻辑：医生点击某一个就诊单，写下诊断信息点上传，完成后跳转到开药界面对刚刚新建的就诊单加入药品
     * </p>
     * @param appointmentId
     * @param statement
     * @return 返回信息中带上appointmentId，方便新建药品。
     */
    @PostMapping("{appointmentId}")
    public R addMedicalReport(@PathVariable int appointmentId,String statement){
        //TODO: 如何使一个报告包含多个药方。 待处理。。。
        MedicalReport medicalReport = MedicalReport.builder()
                .appointmentId(appointmentId)
                .statement(statement)
                .build();
        medicalReportMapper.insert(medicalReport);
        int prescriptionId = medicalReportMapper.selectCount(new QueryWrapper<>());

        return null;
    }
}
