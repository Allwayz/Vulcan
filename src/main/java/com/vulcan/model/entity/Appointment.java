package com.vulcan.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allwayz
 * @since 2020-03-06
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class Appointment {

    private static final long serialVersionUID = 1L;

    @TableId(value = "appointment_id", type = IdType.AUTO)
    private Integer appointmentId;

    private LocalDateTime appointmentDate;

    private Integer patientUserId;

    private Integer doctorsUserId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
