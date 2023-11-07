package controller;

import javax.swing.JOptionPane;

import entity.UserAccount;

public class SuspendUserAccountController {
	
	private UserAccount userAccount;

    public SuspendUserAccountController(UserAccount userAccount) {
        this.userAccount=userAccount;
    }

    public void deleteUserAccount(String username) {
        boolean deleted = userAccount.deleteUserByUsername(username);

        if (deleted) {
        	JOptionPane.showMessageDialog(null, "User account is deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        	
        } else {
        	JOptionPane.showMessageDialog(null, "Failed to delete the user account", "Error", JOptionPane.ERROR_MESSAGE);
        	
        }
    }

}
