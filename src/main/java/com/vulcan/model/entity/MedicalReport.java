package com.vulcan.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allwayz
 * @since 2020-04-04
 */
@Data
@Builder
@EqualsAndHashCode()
@Accessors(chain = true)
public class MedicalReport {

    private static final long serialVersionUID = 1L;

    @TableId(value = "medical_report_id", type = IdType.AUTO)
    private Integer medicalReportId;

    private String statement;

    private Integer appointmentId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
