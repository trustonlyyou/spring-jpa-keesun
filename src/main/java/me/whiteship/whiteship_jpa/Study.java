package me.whiteship.whiteship_jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Study {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne // 양방향의 관계에서는 Foreign Key 를 가진 쪽이 owner 이다.
    private Account owner;

}
