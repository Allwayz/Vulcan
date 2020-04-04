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
public class MedicineType{

    private static final long serialVersionUID = 1L;

    @TableId(value = "medicine_type_id", type = IdType.AUTO)
    private Integer medicineTypeId;

    private String medicineTypeName;

    private String medicineTypeStatus;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
