package controller;
import javax.swing.*;
import entity.User;
import entity.UserAccount;

public class LoginController {
    private UserAccount userAccount;

    public LoginController(UserAccount userAccount) {
    	this.userAccount=userAccount;
//         Initialize some user data (in-memory for simplicity);
//        userAccount = new UserAccount("admin", "password123");

    }

    public boolean authenticate(String username, String password) {
    	
//        if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
//            return true;
//        }
//        return false;
    	
        if (userAccount.authenticateUserAccount(username, password)==true) {
            return true;
        }
        return false;
    }

}
