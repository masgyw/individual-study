package cn.gyw.springboot.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_account")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNo;

    private String password;
}
