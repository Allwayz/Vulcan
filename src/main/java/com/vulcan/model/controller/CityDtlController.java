package com.vulcan.model.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.CityDtl;
import com.vulcan.model.entity.ProvinceDtl;
import com.vulcan.model.mapper.CityDtlMapper;
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
@RequestMapping("/city")
public class CityDtlController extends ApiController {
    @Autowired
    private CityDtlMapper cityDtlMapper;
    @Autowired
    private ProvinceDtlMapper provinceDtlMapper;

    @GetMapping("{provinceName}")
    public R getCityByProvince(@PathVariable String provinceName){
        ProvinceDtl provinceDtl = provinceDtlMapper.selectOne(new QueryWrapper<ProvinceDtl>().eq("province_dtl_name",provinceName));
        return success(cityDtlMapper.selectList(new QueryWrapper<CityDtl>().eq("province_dtl_id",provinceDtl.getProvinceDtlId())));
    }
}
