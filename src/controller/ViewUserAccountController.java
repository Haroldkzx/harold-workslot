package controller;

import java.util.List;

import entity.UserAccount;
import entity.UserAccount;

public class ViewUserAccountController {
		private UserAccount userAccount;
	    public ViewUserAccountController(UserAccount userAccount) {
	        this.userAccount = userAccount;
	    }
	     
	
		public List<UserAccount> viewUserAccount() {
			return userAccount.view();			
		}

}
