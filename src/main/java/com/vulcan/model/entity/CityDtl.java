package com.vulcan.model.entity;

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
public class CityDtl extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer cityDtlId;

    private String cityDtlName;

    private Integer provinceDtlId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;


}
