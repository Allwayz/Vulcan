package com.vulcan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vulcan.POJO.ResultObject;
import com.vulcan.model.entity.DepartmentDtl;
import com.vulcan.model.entity.Role;
import com.vulcan.model.entity.User;
import com.vulcan.model.mapper.DepartmentDtlMapper;
import com.vulcan.model.mapper.RoleMapper;
import com.vulcan.model.mapper.UserMapper;
import com.vulcan.util.IdNumberFormatCheckUtil;
import com.vulcan.util.MailFormatCheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     基础增删改查的类
 * </p>
 *
 * @author allwayz
 * @since 2020-03-08
 */
@Controller
public class BaseController {
    private Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DepartmentDtlMapper departmentDtlMapper;

    /**
     * <p>
     *     新建用户的接口
     *     输入的email必须唯一
     *     会检查输入的身份证号格式和邮箱格式
     * </p>
     * @param password
     * @param idNumber
     * @param email
     * @param firstName
     * @param lastName
     * @param role_desc
     * @param department_dtl
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "users", method = {RequestMethod.POST})
    public ResultObject addUsers(String password, String idNumber, String email, String firstName, String lastName, String role_desc, String department_dtl) {
        //具体逻辑。
        ResultObject resultObject = new ResultObject();
        Map<String, String> map = new HashMap<>();

        int userListSize = userMapper.selectList(new QueryWrapper<User>().like("user_email",email)).size();
        logger.info(String.valueOf(userListSize));
        while (userListSize == 0) {
            Role role = roleMapper.selectOne(new QueryWrapper<Role>().eq("role_desc",role_desc));
            if (IdNumberFormatCheckUtil.CheckCheck(idNumber) && MailFormatCheckUtil.checkEmailFormat(email)) {
                User user = User.builder()
                        .userEmail(email)
                        .userIdentityNumber(idNumber)
                        .userPassword(password)
                        .firstName(firstName)
                        .lastName(lastName)
                        //.roleId(role.getRoleId())
                        .build();
                logger.info(user.toString());
                logger.info(department_dtl);
                if (department_dtl.length() == 0) {
                    user.setDepartmentDtlId(0);
                } else {
                    user.setDepartmentDtlId(
                            1
//                        departmentDtlMapper.selectOne(
//                                new QueryWrapper<DepartmentDtl>()
//                                        .eq("department_dtl_name",department_dtl)).getDepartmentId()
                    );
                }
                map.put("Email", user.getUserEmail());
                map.put("First Name", user.getFirstName());
                map.put("Last Name", user.getLastName());
                map.put("Password", user.getUserPassword());
                map.put("DepartmentDtlId", user.getDepartmentDtlId().toString());
                resultObject.setStringStringMap(map);
                resultObject.setStatusCode(200);
                return resultObject;
            } else {
                resultObject.setStringStringMap(null);
                resultObject.setStatusCode(404);
                return resultObject;
            }
        }
        resultObject.setStringStringMap(null);
        resultObject.setStatusCode(500);
        return resultObject;
    }

    /**
     * <p>
     *     查询用户
     * </p>
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "users/{id}", method = {RequestMethod.GET})
    public ResultObject getUsers(@PathVariable(value = "id") String id) {
        logger.info(id);
        ResultObject resultObject = new ResultObject();
        resultObject.setStatusCode(100);
        return resultObject;
    }

    /**
     * <p>
     *     更新用户
     * </p>
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "user/{email}", method = {RequestMethod.PUT})
    public ResponseBody updateUsers(@PathVariable(value = "email") String password, String email, String firstName, String lastName){
        ResultObject resultObject = new ResultObject();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        if(user == null){
            resultObject.setStatusCode(404);
        }else {
            User userToUpdate = User.builder().firstName(firstName)
                    .lastName(lastName)
                    .userPassword(password).build();
            userMapper.update(userToUpdate,new QueryWrapper<>());
            resultObject.setStatusCode(200);
        }
        return (ResponseBody) resultObject;
    }

    /**
     * <p>
     *
     * </p>
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "users/{email}", method = {RequestMethod.DELETE})
    public ResultObject deleteUser(@PathVariable(value = "email") String email){
        ResultObject resultObject = new ResultObject();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        if(user == null){
            resultObject.setStatusCode(404);
        }else {
            userMapper.deleteById(user.getUserId());
            resultObject.setStatusCode(200);
        }
        return resultObject;
    }
}
