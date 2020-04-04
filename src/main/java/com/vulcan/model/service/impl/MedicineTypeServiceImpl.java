package com.vulcan.model.service.impl;

import com.vulcan.model.entity.MedicineType;
import com.vulcan.model.mapper.MedicineTypeMapper;
import com.vulcan.model.service.IMedicineTypeService;
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
public class MedicineTypeServiceImpl extends ServiceImpl<MedicineTypeMapper, MedicineType> implements IMedicineTypeService {

}
