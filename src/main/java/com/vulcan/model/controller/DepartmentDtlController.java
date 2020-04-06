package com.vulcan.model.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.Department;
import com.vulcan.model.entity.DepartmentDtl;
import com.vulcan.model.mapper.DepartmentDtlMapper;
import com.vulcan.model.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/department-dtl")
public class DepartmentDtlController extends ApiController {
    @Autowired
    private DepartmentDtlMapper departmentDtlMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("{departmentName}")
    public R getDepartmentDtlByDepartment(@PathVariable String departmentName){
        Department department = departmentMapper.selectOne(new QueryWrapper<Department>().eq("department_name",departmentName));
        return success(departmentDtlMapper.selectList(new QueryWrapper<DepartmentDtl>().eq("department_id",department.getDepartmentId())));
    }
}
