package com.example.topvideo.domain.api;

import com.example.topvideo.domain.user.User;
import com.example.topvideo.domain.user.UserDao;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();

    public void register(UserRegistration userRegistration){
        User userToSave = UserMapper.map(userRegistration);
        hashPasswordWithSha256(userToSave);
        userDao.save(userToSave);
    }

    public User getUser(String username){
        return userDao.findByUsername(username).orElseThrow();
    }

    public UserProfile getUserData(User user){
        return new UserProfile(
                user.getUsername(),
                user.getEmail(),
                user.getRegistrationDate(),
                userDao.countDiscoveryByUserId(user)
        );
    }


    private void hashPasswordWithSha256(User user) {
        String sha256Password = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(sha256Password);
    }

    private static class UserMapper{
         static User map(UserRegistration userRegistration){
            return new User(
                    userRegistration.getUsername(),
                    userRegistration.getEmail(),
                    userRegistration.getPassword(),
                    LocalDateTime.now()
            );
        }
    }
}
