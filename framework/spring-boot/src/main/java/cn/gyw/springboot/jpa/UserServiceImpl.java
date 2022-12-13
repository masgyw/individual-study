package cn.gyw.springboot.jpa;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("jpaUserService")
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.saveAndFlush(userEntity);
    }

    @Override
    public UserEntity findByUserName(String userName) {
        return userRepository.findById(1L).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
