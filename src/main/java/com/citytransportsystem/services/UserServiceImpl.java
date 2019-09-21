package com.citytransportsystem.services;

import com.citytransportsystem.dto.User;
import com.citytransportsystem.repository.jdbc.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManagerImpl userManagerImpl;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long idUser) {
        return userRepository.get(idUser);
    }

    @Override
    public String hash(String password) {
        return password;
    }

    @Override
    public boolean checkUnique(User user) {
        return true;
    }

    @Override
    public void regUser(User user) {
        user.setPassword(hash(user.getPassword()));
        userRepository.create(user);
}

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(password);
    }

    @Override
    public boolean authUser(String login, String password) {
        User currentUser = userRepository.get(login);
        if(checkPassword(currentUser, password)){
            userManagerImpl.setUser(currentUser);
            return true;
        }
        else{
            return false;
        }
    }
}
