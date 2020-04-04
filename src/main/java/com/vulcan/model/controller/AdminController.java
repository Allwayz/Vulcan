package com.vulcan.model.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.Admin;
import com.vulcan.model.mapper.AdminMapper;
import com.vulcan.util.BCryptPasswordEncoderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Allwayz
 * @since 2020-04-04
 */
@Slf4j
@Transactional
@RestController
@RequestMapping("/admin")
public class AdminController extends ApiController {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    @GetMapping("{userName}/{Password}")
    public R getAdmin(@PathVariable String userName, @PathVariable String Password){
        log.info(userName+Password);
        if(userName.isEmpty()||Password.isEmpty()){
            return failed("Empty Field.");
        }else {
            Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("admin_name",userName));
            if(bCryptPasswordEncoderUtil.matches(Password,admin.getAdminPassword())){
                return success(admin);
            }else {
                return failed("User Name or Password incorrect.");
            }
        }
    }

    @PostMapping("{userName}/{Password}")
    public R addAdmin(@PathVariable String userName, @PathVariable String Password){
        if(userName.isEmpty()||Password.isEmpty()){
            return failed("Empty Field.");
        }else {
            Admin admin = Admin.builder().adminName(userName).adminPassword(Password).build();
            return success(adminMapper.insert(admin));
        }
    }

    @PutMapping("{userName}/{Password}")
    public R updateAdmin(@PathVariable String Password, @PathVariable String userName){
        if(Password.isEmpty()){
            return failed("Enter The Password");
        }else {
            Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("admin_name",userName));
            admin.setAdminPassword(bCryptPasswordEncoderUtil.encode(Password));
            return success(adminMapper.updateById(admin));
        }
    }
}
