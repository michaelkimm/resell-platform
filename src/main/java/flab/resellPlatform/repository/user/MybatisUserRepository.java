package flab.resellPlatform.repository.user;

import flab.resellPlatform.domain.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public UserEntity save(UserEntity userEntity) {
//        System.out.println("MybatisUserRepository");
        userMapper.save(userEntity);
        return userEntity;
    }

    @Override
    public Optional<UserEntity> findByUsername(String phoneNumber) {
        return userMapper.findByUsername(phoneNumber);
    }

    @Override
    public List<UserEntity> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int getUsernameCount(String username) {
        return userMapper.getUsernameCount(username);
    }

}
