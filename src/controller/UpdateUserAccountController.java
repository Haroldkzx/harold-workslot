package controller;

import entity.UserAccount;
import entity.UserAccount;

public class UpdateUserAccountController {
				//constructor
				private UserAccount userAccount;
				public UpdateUserAccountController(UserAccount userAccount) {
			        this.userAccount = userAccount;
			    }
	
	
				public int updateUserAccount(UserAccount u) {
					return userAccount.update(u);
				}
				public UserAccount getUserAccountByIDno(int ID) {
					return userAccount.getUserAccountByIDno(ID);
				}	
}
