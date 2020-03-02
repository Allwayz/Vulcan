package com.vulcan.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 每个表的公共字段，都是自动生成的数据，在new全参构造函数的
 * 时候不用set这些数据
 *
 * @author Allwayz
 * @since 2020-03-02
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
public class BaseEntity {
    /**
     * Create time.
     */
    private LocalDateTime createTime;

    /**
     * Update time.
     */
    private LocalDateTime updateTime;

    /**
     * Delete flag.
     */
    private Integer isDelete;

}
