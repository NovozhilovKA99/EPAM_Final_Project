package com.citytransportsystem.service;

import com.citytransportsystem.dto.User;
import com.citytransportsystem.repository.jdbc.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
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
        try {
            userRepository.get(user.getLogin());
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public void regUser(User user) {
        user.setPassword(hash(user.getPassword()));
        userRepository.create(user);
}

    @Override
    public boolean checkPassword(User user, String password) {
        return user.getPassword().equals(hash(password));
    }

    @Override
    public boolean authUser(String login, String password) {
        User currentUser;
        try {
            currentUser = userRepository.get(login);
        }
        catch (Exception exc){
            return false;
        }
        if(checkPassword(currentUser, password)){
            userManagerImpl.setUser(currentUser);
            return true;
        }
        else{
            return false;
        }
    }
}
