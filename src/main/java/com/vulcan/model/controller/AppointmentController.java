package com.vulcan.model.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.vulcan.model.entity.Appointment;
import com.vulcan.model.entity.User;
import com.vulcan.model.mapper.AppointmentMapper;
import com.vulcan.model.mapper.UserMapper;
import com.vulcan.util.DataTimeConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Allwayz
 * @since 2020-04-04
 */
@RestController
@RequestMapping("/appointment")
public class AppointmentController extends ApiController {
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DataTimeConverterUtil dataTimeConverterUtil;

    /**
     * <p>
     *     通过email得到预约就诊的信息
     * </p>
     *
     * @param email
     * @return
     */
    @GetMapping("{email}")
    public R getAppointment(@PathVariable String email){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",email));
        List<Appointment> appointmentList;
        if (user.getRoleId() == 2){
            //TODO: doctor
            appointmentList = appointmentMapper.selectList(new QueryWrapper<Appointment>().eq("doctor_user_id",user.getUserId()));
        }else {
            //TODO: patient
            appointmentList = appointmentMapper.selectList(new QueryWrapper<Appointment>().eq("patient_user_id",user.getUserId()));
        }
        return success(appointmentList);
    }

    /**
     * <p>
     *     传入医生用户和病人用户还有时间来新建一个预约
     * </p>
     *
     * @param patient
     * @param doctor
     * @param time
     * @return
     */
    @PostMapping("{patient}/{doctor}/{time}")
    public R addAppointment(@PathVariable String patient, @PathVariable String doctor, @PathVariable String time){
        User patientUser = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",patient));
        User doctorUser = userMapper.selectOne(new QueryWrapper<User>().eq("user_email",doctor));
        LocalDateTime localDateTime = dataTimeConverterUtil.stringToLocalDataTime(time);
        Appointment appointment = Appointment.builder()
                .patientUserId(patientUser.getUserId())
                .doctorUserId(doctorUser.getUserId())
                .appointmentDate(localDateTime).build();
        return success(appointmentMapper.insert(appointment));
    }

    /**
     * <p>
     *     取消一个预约
     * </p>
     * @param Id
     * @return
     */
    @DeleteMapping("{Id}")
    public R cancelAppointment(@PathVariable String Id){
        return success(appointmentMapper.deleteById(Id));
    }

}
