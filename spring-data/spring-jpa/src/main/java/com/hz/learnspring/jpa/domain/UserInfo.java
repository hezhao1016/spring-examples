package com.hz.learnspring.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/** 用户信息
 * @Author hezhao
 * @Time 2018-06-30 22:37
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "user_info")
// 命名查询
@NamedQuery(name = "UserInfo.searchUserName",query = "select u from UserInfo u where u.userName like :userName")
public class UserInfo {

    // Spring Boot 2.0 需要指定主键的自增策略，这个和 Spring Boot 1.0 有所区别，1.0 会使用默认的策略。
    @Id
    @Column(name= "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name= "user_name", nullable = false)
    private String userName;

    @Column
    private String password;

    // 一对多
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE}, mappedBy = "userInfo")
    // 在循环的时候过滤某个字段, 以免死循环
    @JsonIgnore
    private Set<Weibo> weibos;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
