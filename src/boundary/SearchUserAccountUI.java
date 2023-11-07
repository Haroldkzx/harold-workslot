package boundary;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.SearchUserAccountController;
import controller.SuspendUserAccountController;
import controller.ViewUserAccountController;
import entity.UserAccount;
public class SearchUserAccountUI extends JFrame {
	
	 private SearchUserAccountController controller;

	public SearchUserAccountUI(SearchUserAccountController controller) {
		this.controller=controller;
		
		var name = JOptionPane.showInputDialog("Search User Account");
		System.out.println(name);
		//Code to view data in JTable
		List<UserAccount> list=controller.searchUserAccount(name);
		int size=list.size();
		if (size == 0) {
		    // Handle the case where no user account with the specified username was found
		    // You can display an error message or take appropriate action here.
			 JOptionPane.showMessageDialog(null, "Username not found.", "User Not Found", JOptionPane.ERROR_MESSAGE);
		} else {
		
			String data[][]=new String[size][7];
			int row=0;
			for(UserAccount a:list){
	
				data[row][0]=a.getUserName();
				data[row][1]=String.valueOf(a.getId());
				data[row][2]=a.getPassword();
				data[row][3]=a.getDateOfBirth();
				data[row][4]=a.getEmailAddr();
				data[row][5]=a.getAddress();
				data[row][6]=a.getUserProfile();
	
				row++;
				String columnNames[]={"Name","Id","Password","Date OF Birth","Email","Address","Profile"};

				
				JTable jt=new JTable(data,columnNames);
				JScrollPane sp=new JScrollPane(jt);
				add(sp);
				
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 800, 400);
		 }
		}

		}
 }