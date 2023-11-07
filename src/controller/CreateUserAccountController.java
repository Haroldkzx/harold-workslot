package controller;


import entity.UserAccount;



public class CreateUserAccountController {

	private UserAccount userAccount;
	//constructor
    public CreateUserAccountController(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
     
	public boolean createUserAccount(UserAccount userAccount) {

        boolean created = userAccount.createUser(userAccount);
        return created;

    }
}