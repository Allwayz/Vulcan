package com.vulcan.model.service.impl;

import com.vulcan.model.entity.Admin;
import com.vulcan.model.mapper.AdminMapper;
import com.vulcan.model.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Allwayz
 * @since 2020-03-02
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
