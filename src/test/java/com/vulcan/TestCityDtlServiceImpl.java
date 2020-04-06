package com.vulcan;


        import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
        import com.vulcan.model.entity.CityDtl;
        import com.vulcan.model.mapper.CityDtlMapper;
        import com.vulcan.util.DataTimeConverterUtil;
        import lombok.extern.slf4j.Slf4j;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
        import org.springframework.test.context.junit4.SpringRunner;

        import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@SpringBootTest
public class TestCityDtlServiceImpl {

    @Autowired
    private CityDtlMapper cityDtlMapper;
    @Autowired
    private DataTimeConverterUtil dataTimeConverterUtil;

    @Test
    public void getCityDtlByName(){
        String cityName = "苏州";
        CityDtl cityDtl = cityDtlMapper.selectOne(new QueryWrapper<CityDtl>().eq("city_dtl_name",cityName));
        //CityDtl cityDtl = cityDtlMapper.selectById(122);
        log.info(cityDtl.toString());
    }

    @Test
    public void updateAllCity(){
        List<CityDtl> cityDtlList = cityDtlMapper.selectList(new QueryWrapper<>());
        for(CityDtl cityDtl:cityDtlList){
            cityDtlMapper.updateById(cityDtl);
        }
    }

    @Test
    public void stringToLocalDataTime(){
        String ss = "2019-12-22 13:29";
        System.out.println(dataTimeConverterUtil.stringToLocalDataTime(ss));
    }
}
