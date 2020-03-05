package com.vulcan.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allwayz
 * @since 2020-03-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Medicine extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "medicine_id", type = IdType.AUTO)
    private Integer medicineId;

    private String medicineName;

    private String medicineCode;

    private String status;

    private Integer medicineCount;


}
