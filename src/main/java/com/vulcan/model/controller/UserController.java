package com.vulcan.model.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.CityDtl;
import com.vulcan.model.entity.DepartmentDtl;
import com.vulcan.model.entity.Role;
import com.vulcan.model.entity.User;
import com.vulcan.model.mapper.CityDtlMapper;
import com.vulcan.model.mapper.DepartmentDtlMapper;
import com.vulcan.model.mapper.RoleMapper;
import com.vulcan.model.mapper.UserMapper;
import com.vulcan.util.BCryptPasswordEncoderUtil;
import com.vulcan.util.IdNumberFormatCheckUtil;
import com.vulcan.util.MailFormatCheckUtil;
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
@RequestMapping("/user")
public class UserController extends ApiController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;
    @Autowired
    private CityDtlMapper cityDtlMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DepartmentDtlMapper departmentDtlMapper;

    @PostMapping()
    public R registerUser(String IdNumber,String Password, String email,String firstName,String lastName,String roleDesc,String cityName,String department) {
        log.info("Id:{} | Password:{} | email:{} | firstName:{} | lastName:{} | roleDesc:{} | cityName:{}",
                IdNumber,Password,email,firstName,lastName,roleDesc,cityName);
        if(IdNumber.isEmpty()||Password.isEmpty()||email.isEmpty()||firstName.isEmpty()||lastName.isEmpty()||roleDesc.isEmpty()||cityName.isEmpty()){
            return failed("Empty Field");
        }else {
            if(IdNumberFormatCheckUtil.CheckCheck(IdNumber)&& MailFormatCheckUtil.checkEmailFormat(email)){
                String encodeIdNumber = bCryptPasswordEncoderUtil.encode(IdNumber);
                String encodePassword = bCryptPasswordEncoderUtil.encode(Password);
                int city_dtl_id = cityDtlMapper.selectOne(new QueryWrapper<CityDtl>().eq("city_dtl_name",cityName)).getCityDtlId();
                int role_id = roleMapper.selectOne(new QueryWrapper<Role>().eq("role_desc",roleDesc)).getRoleId();
                User user = User.builder()
                        .userEmail(email)
                        .userIdentityNumber(encodeIdNumber)
                        .userPassword(encodePassword)
                        .firstName(firstName)
                        .lastName(lastName)
                        .roleId(role_id)
                        .cityDtlId(city_dtl_id)
                        .build();
                if (!department.isEmpty()&&roleDesc=="doctor") {
                    int departmentId = departmentDtlMapper.selectOne(new QueryWrapper<DepartmentDtl>().eq("department_dtl_name", department)).getDepartmentDtlId();
                    user.setDepartmentDtlId(departmentId);
                }
                return success(userMapper.insert(user));
            }else {
                return failed("invalid IdNumber or Email");
            }
        }
    }

    @GetMapping()
    public R login(String email,String Password){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        if(bCryptPasswordEncoderUtil.matches(Password,user.getUserPassword())){
            return success(user);
        }else {
            return failed("Wrong Password");
        }
    }

    @PostMapping("{email}")
    public R updateUser(@PathVariable String email,String Password,String firstName,String lastName,String cityName){
        if(Password.isEmpty()&&firstName.isEmpty()&&lastName.isEmpty()&&cityName.isEmpty()){
            return failed("Nothing To Update");
        }else {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
            if(!Password.isEmpty()){
                user.setUserPassword(bCryptPasswordEncoderUtil.encode(Password));
            }
            if(!firstName.isEmpty()){
                user.setFirstName(firstName);
            }
            if(!lastName.isEmpty()){
                user.setLastName(lastName);
            }
            if(!cityName.isEmpty()){
                user.setCityDtlId(
                        cityDtlMapper.selectOne(new QueryWrapper<CityDtl>().eq("city_dtl_name",cityName)).getCityDtlId()
                );
            }
            return success(userMapper.updateById(user));
        }
    }

    @DeleteMapping("{email}")
    public R removeUser(@PathVariable String email){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        return success(userMapper.deleteById(user.getUserId()));
    }

}
