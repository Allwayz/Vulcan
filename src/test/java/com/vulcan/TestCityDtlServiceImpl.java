package com.vulcan;


import com.vulcan.model.mapper.CityDtlMapper;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCityDtlServiceImpl {
    private Logger logger = LoggerFactory.getLogger(TestCityDtlServiceImpl.class);

    @Autowired
    private CityDtlMapper cityDtlMapper;
}
