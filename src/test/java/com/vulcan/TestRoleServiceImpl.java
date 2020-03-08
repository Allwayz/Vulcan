package com.vulcan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vulcan.model.entity.Role;
import com.vulcan.model.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoleServiceImpl {
    private Logger logger = LoggerFactory.getLogger(TestRoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 测试从数据库打印全部身份
     */
    @Test
    public void testSelectAll(){
        List<Role> roleList = roleMapper.selectList(null);
        for(Role role : roleList){
            logger.info(role.toString());
        }
    }

    /**
     * 测试添加一行数据
     */
    @Test
    public void testInsertRole(){
        Scanner input = new Scanner(System.in);
        Role role = new Role();
        role.setRoleDesc("patient");
        roleMapper.insert(role);
    }

    /**
     * 测试打印数据行数
     */
    @Test
    public void testCount(){
        logger.info(roleMapper.selectCount(new QueryWrapper<Role>()).toString());
    }
}
