package com.vulcan.model.service.impl;

import com.vulcan.model.entity.Role;
import com.vulcan.model.mapper.RoleMapper;
import com.vulcan.model.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Allwayz
 * @since 2020-03-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
