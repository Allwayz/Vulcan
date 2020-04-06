package com.vulcan.model.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.mapper.DepartmentSystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/department-system")
public class DepartmentSystemController extends ApiController {
    @Autowired
    private DepartmentSystemMapper departmentSystemMapper;

    @GetMapping()
    public R getDepartmentSystemList(){
        return success(departmentSystemMapper.selectList(new QueryWrapper<>()));
    }

    @PostMapping()
    public R addDepartmentSystem(){
        return null;
    }
}
