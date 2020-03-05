package com.vulcan.model.service.impl;

import com.vulcan.model.entity.Prescription;
import com.vulcan.model.mapper.PrescriptionMapper;
import com.vulcan.model.service.IPrescriptionService;
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
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements IPrescriptionService {

}
