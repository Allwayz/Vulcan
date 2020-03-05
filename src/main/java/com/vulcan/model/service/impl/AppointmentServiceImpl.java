package com.vulcan.model.service.impl;

import com.vulcan.model.entity.Appointment;
import com.vulcan.model.mapper.AppointmentMapper;
import com.vulcan.model.service.IAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Allwayz
 * @since 2020-03-05
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements IAppointmentService {

}
