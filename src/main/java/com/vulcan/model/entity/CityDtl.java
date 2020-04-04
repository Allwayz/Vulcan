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
 * @since 2020-04-04
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class CityDtl{

    private static final long serialVersionUID = 1L;

    @TableId(value = "city_dtl_id", type = IdType.AUTO)
    private Integer cityDtlId;

    private String cityDtlName;

    private Integer provinceDtlId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
