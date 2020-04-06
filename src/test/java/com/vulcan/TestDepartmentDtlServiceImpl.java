package com.vulcan;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vulcan.model.entity.Department;
import com.vulcan.model.entity.DepartmentDtl;
import com.vulcan.model.mapper.DepartmentDtlMapper;
import com.vulcan.model.mapper.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDepartmentDtlServiceImpl {
    @Autowired
    private DepartmentDtlMapper departmentDtlMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void addDepartmentDtls(){
        List<Department> departmentList = departmentMapper.selectList(new QueryWrapper<>());
        for(Department department:departmentList){
            DepartmentDtl departmentDtl1 = DepartmentDtl.builder()
                    .departmentDtlName(department.getDepartmentName()+"01")
                    .departmentId(department.getDepartmentId())
                    .build();
            departmentDtlMapper.insert(departmentDtl1);
            DepartmentDtl departmentDtl2 = DepartmentDtl.builder()
                    .departmentDtlName(department.getDepartmentName()+"02")
                    .departmentId(department.getDepartmentId())
                    .build();
            departmentDtlMapper.insert(departmentDtl2);
        }
    }
}
