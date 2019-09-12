package com.citytransportsystem.services;

import com.citytransportsystem.dto.DB.UserDB;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class UserManager {

        private UserDB userDB;

        public UserDB getUserDB() {
            return userDB;
        }

        public void setUserDB(UserDB userDB) {
            this.userDB = userDB;
        }
}
