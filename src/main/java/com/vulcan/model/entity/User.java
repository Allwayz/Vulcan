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
public class User{

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String userIdentityNumber;

    private String userPassword;

    private String userEmail;

    private String firstName;

    private String lastName;

    private String bloodType;

    private Integer roleId;

    private Integer cityDtlId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

    private Integer departmentDtlId;


}
