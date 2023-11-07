package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.CreateUserAccountController;
import controller.ViewUserAccountController;
import entity.User;
import entity.UserAccount;


public class ViewUserAccountUI extends JFrame {
	
	private ViewUserAccountController controller;
	public ViewUserAccountUI(ViewUserAccountController viewUserAccountController) {
    	this.controller= viewUserAccountController;
    	
    	
		//Code to view data in JTable
		List<UserAccount> list=viewUserAccountController.viewUserAccount();
		int size=list.size();
		
		String data[][]=new String[size][8];
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
		}
		String columnNames[]={"Name","Id","Password","Date OF Birth","Email","Address","Profile","Delete"};
		
		JTable jt=new JTable(data,columnNames);
		JScrollPane sp=new JScrollPane(jt);
		add(sp);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}
}