package com.vulcan.model.entity;

import java.time.LocalDateTime;

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
 * @since 2020-03-06
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class ProvinceDtl {

    private static final long serialVersionUID = 1L;
    @TableId(value = "province_dtl_id", type = IdType.AUTO)
    private Integer provinceDtlId;

    private String provinceDtlName;

    private Integer nationalDtlId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
