package com.shop.model.service;

public interface RoleManagerInterface {
    public static String cacheName = "roleCache";
    public Long getRoleIdFromName(String roleName);
    public String getNameFromRoleId(long roleId);
}
