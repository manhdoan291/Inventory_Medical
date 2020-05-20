package com.java1906.climan.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserInfo implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Date createTime;
    private Date updateTime;

    @Transient
    private String token;
    @Transient
    private String role;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo castedObject = (UserInfo) obj;
        if (castedObject.getId() == this.getId()) {
            return true;
        }
        return false;
    }


    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
