package com.kingland.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    /**
     * ADMIN权限
     */
    ADMIN("ADMIN"),

    /**
     * COMMON权限
     */
    COMMON("COMMON");

    /**
     * 用户权限
     */
    private String role;
}
