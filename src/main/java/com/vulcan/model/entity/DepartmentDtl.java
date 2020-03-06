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
public class DepartmentDtl {

    private static final long serialVersionUID = 1L;

    @TableId(value = "department_dtl_id", type = IdType.AUTO)
    private Integer departmentDtlId;

    private String departmentDtlName;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

    private Integer departmentId;


}
