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
public class Medicine {

    private static final long serialVersionUID = 1L;

    @TableId(value = "medicine_id", type = IdType.AUTO)
    private Integer medicineId;

    private String medicineName;

    private String medicineCode;

    private String status;

    private Integer medicineCount;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

    private Integer medicineTypeId;


}
