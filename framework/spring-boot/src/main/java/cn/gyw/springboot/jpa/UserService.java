package cn.gyw.springboot.jpa;

public interface UserService {

    UserEntity save(UserEntity userEntity);

    UserEntity findByUserName(String userName);

    void deleteById(Long id);

}
