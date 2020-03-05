package com.vulcan.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Allwayz
 * @since 2020-03-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class NationalDtl extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "national_dtl_id", type = IdType.AUTO)
    private Integer nationalDtlId;

    private String nationalDtlName;

    private String nationalDtlCode;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
