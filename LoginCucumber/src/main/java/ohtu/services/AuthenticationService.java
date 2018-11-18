package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        int count=0;
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        
        char[] chars = password.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
          if(Character.isDigit(c)){
             count++;
             }
        }
        
        if (username.length()>2 && password.length()>7 && count > 0){
            return true;
        }else {
            return false;
        }

    }
}
