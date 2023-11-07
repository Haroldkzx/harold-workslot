package controller;

import java.util.List;

import entity.UserAccount;
import entity.UserAccount;

public class SearchUserAccountController {
	
	private UserAccount userAccount;
	
	public SearchUserAccountController(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<UserAccount> searchUserAccount(String username) {
		return userAccount.searchUserAccount(username);			
	}
}
