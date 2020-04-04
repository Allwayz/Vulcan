package com.vulcan.model.service.impl;

import com.vulcan.model.entity.ProvinceDtl;
import com.vulcan.model.mapper.ProvinceDtlMapper;
import com.vulcan.model.service.IProvinceDtlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Allwayz
 * @since 2020-04-04
 */
@Service
@Transactional
public class ProvinceDtlServiceImpl extends ServiceImpl<ProvinceDtlMapper, ProvinceDtl> implements IProvinceDtlService {

}
