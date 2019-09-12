package com.citytransportsystem.services;

import com.citytransportsystem.dto.DB.UserDB;
import com.citytransportsystem.repository.jdbc.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDB getById(Long idUser) {
        return userRepository.get(idUser);
    }

    @Override
    public void regUser(UserDB userDB) {
        userRepository.create(userDB);
    }

    //TODO RSA encryption
    @Override
    public boolean checkPassword(UserDB userDB, String password){
        return true;
    }

    @Override
    public UserDB checkUser(Long idUser, String password) {
        UserDB currentUserDB = userRepository.get(idUser);
        if (
                currentUserDB != null
                        && checkPassword(currentUserDB, password)
        ) {
            return currentUserDB;
        } else {
            return null;
        }
    }
}
