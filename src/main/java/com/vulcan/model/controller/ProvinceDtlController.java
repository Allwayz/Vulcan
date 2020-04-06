package com.vulcan.model.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.NationalDtl;
import com.vulcan.model.entity.ProvinceDtl;
import com.vulcan.model.mapper.NationalDtlMapper;
import com.vulcan.model.mapper.ProvinceDtlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/province")
public class ProvinceDtlController extends ApiController {
    @Autowired
    private ProvinceDtlMapper provinceDtlMapper;
    @Autowired
    private NationalDtlMapper nationalDtlMapper;

    @GetMapping("{nationalName}")
    public R getProvinceByNational(@PathVariable String nationalName){
        NationalDtl nationalDtl = nationalDtlMapper.selectOne(new QueryWrapper<NationalDtl>().eq("national_dtl_name",nationalName));
        return success(provinceDtlMapper.selectList(new QueryWrapper<ProvinceDtl>().eq("national_dtl_id",nationalDtl.getNationalDtlId())));
    }
}
