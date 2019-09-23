package com.citytransportsystem.service;

import com.citytransportsystem.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@SessionScope
@Service
public class UserManagerImpl implements UserManager {

        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Boolean authorised(){
            return user == null;
        }
}
