package com.cskaoyan.bean;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 16:28
 */
public class SysUser {
    private String id;
    private String username;
    private String password;
    private String locked;
    private String rolename = "超级管理员";

    public SysUser() {
    }

    public SysUser(String id, String username, String password, String locked, String rolename) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.locked = locked;
        this.rolename = rolename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", locked='" + locked + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
