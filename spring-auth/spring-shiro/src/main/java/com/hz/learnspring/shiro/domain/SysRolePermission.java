package com.hz.learnspring.shiro.domain;

/**
 * @Author hezhao
 * @Time 2018-08-05 23:52
 */
public class SysRolePermission {

    private Integer permissionId;

    private Integer roleId;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
