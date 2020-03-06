package com.vulcan;

import com.vulcan.model.mapper.DepartmentDtlMapper;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDepartmentDtlServiceImpl {
    private Logger logger = LoggerFactory.getLogger(TestDepartmentDtlServiceImpl.class);

    @Autowired
    private DepartmentDtlMapper departmentDtlMapper;
}
