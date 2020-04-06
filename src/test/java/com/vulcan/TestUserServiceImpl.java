package com.vulcan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vulcan.model.entity.User;
import com.vulcan.model.mapper.UserMapper;
import com.vulcan.util.BCryptPasswordEncoderUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserServiceImpl {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    @Test
    public void updateUser(){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email","2584491610@qq.com"));
        user.setUserPassword(bCryptPasswordEncoderUtil.encode("123456"));
        userMapper.updateById(user);
    }
}
