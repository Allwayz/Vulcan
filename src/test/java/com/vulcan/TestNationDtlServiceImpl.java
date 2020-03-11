package com.vulcan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vulcan.model.entity.NationalDtl;
import com.vulcan.model.mapper.NationalDtlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestNationDtlServiceImpl {
    private Logger logger = LoggerFactory.getLogger(TestNationDtlServiceImpl.class);

    @Autowired
    private NationalDtlMapper nationalDtlMapper;

    /**
     * 测试从数据库打印所有国家信息
     */
    @Test
    public void testSelectAllNational(){
        List<NationalDtl> nationalDtlList = nationalDtlMapper.selectList(new QueryWrapper<NationalDtl>());
        for(NationalDtl nationalDtl : nationalDtlList){
            logger.info(nationalDtl.toString());
        }
    }
}
