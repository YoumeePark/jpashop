package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    //여기서 member는 Order에 있는 Member member를 뜻함
    //외래키가 Order에 있기 때문에 Order를 연관관계의 주인으로 정했기 때문
    private List<Order> orders = new ArrayList<>();
}