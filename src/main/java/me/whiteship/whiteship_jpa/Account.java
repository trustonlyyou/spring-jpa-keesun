package me.whiteship.whiteship_jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity // 자동으로 테이블로 메핑
@Getter
@Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String yes;

    @Transient // 컬러으로 매핑 하지 않는다.
    private String no;
}
