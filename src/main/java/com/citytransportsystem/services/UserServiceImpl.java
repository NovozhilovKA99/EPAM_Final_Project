package com.citytransportsystem.services;

import com.citytransportsystem.dao.UserRepository;
import com.citytransportsystem.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long idUser) {
        return userRepository.get(idUser);
    }

    @Override
    public void regUser(User user) {
        userRepository.create(user);
    }

    //TODO RSA encryption
    @Override
    public boolean checkPassword(User user, String password){
        return true;
    }

    @Override
    public User checkUser(Long idUser, String password) {
        User currentUser = userRepository.get(idUser);
        if (
                currentUser != null
                        && checkPassword(currentUser, password)
        ) {
            return currentUser;
        } else {
            return null;
        }
    }
}
