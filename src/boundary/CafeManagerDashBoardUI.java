package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class CafeManagerDashBoardUI {
	
	public CafeManagerDashBoardUI{
		
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(400, 10, 480, 700);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
	setContentPane(contentPane);
	
	JLabel lblAdminSection = new JLabel("System Admin Dashboard");
	lblAdminSection.setForeground(Color.DARK_GRAY);
	lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 20));

	JButton btnCreateUserAccount = new JButton("Add User Account");
	btnCreateUserAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			CreateUserAccountUI createUserAccountUI = new CreateUserAccountUI(createUserAccountController);
            createUserAccountUI.setVisible(true);
//			dispose();
		}
	});
	
	JButton btnViewUserAccount = new JButton("View User Account");
	btnViewUserAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ViewUserAccountUI viewUserAccountUI = new ViewUserAccountUI(viewUserAccountController);
			viewUserAccountUI.setVisible(true);
//			dispose();
		}
	});
	
	JButton btnUpdateUserAccount = new JButton("Update User Account");
	btnUpdateUserAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UpdateUserAccountUI updateUserAccountUI = new UpdateUserAccountUI(updateUserAccountController);
			updateUserAccountUI.setVisible(true);
//			dispose();
		}
	});
	
	JButton btnSuspendUserAccount = new JButton("Suspend User Account");
	btnSuspendUserAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	        SuspendUserAccountUI suspendUserAccountUI = new SuspendUserAccountUI(suspendUserAccountController);
	        suspendUserAccountUI.setVisible(true);
//	        dispose();
		}
	});
	
	JButton btnSearchUserAccount = new JButton("Search User Account");
	btnSearchUserAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SearchUserAccountUI searchUserAccountUI = new SearchUserAccountUI(searchUserAccountController);
			searchUserAccountUI.setVisible(true);
//			 dispose();
		}
	});
	
	//User Profiles
	JButton btnCreateUserProfile = new JButton("Add User Profile");
	btnCreateUserProfile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//
			 dispose();
		}
	});
	
	JButton btnViewUserProfile = new JButton("View User Profile");
	btnViewUserProfile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			ViewUserAccountGUI.main(new String[]{});
			 dispose();
		}
	});
	
	JButton btnUpdateUserProfile = new JButton("Update User Profile");
	btnUpdateUserProfile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			CreateUserAccountGUI.main(new String[]{});
			 dispose();
		}
	});
	
	JButton btnSuspendUserProfile = new JButton("Suspend User Profile");
	btnSuspendUserProfile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			ViewUserAccount.main(new String[]{});
			 dispose();
		}
	});
	
	JButton btnSearchUserProfile = new JButton("Search User Profile");
	btnSearchUserProfile.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			ViewUserAccount.main(new String[]{});
			 dispose();
		}
	});
	
	JButton btnLogout = new JButton("Logout");
	btnLogout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 dispose();
		}
	});
	
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(120)
						.addComponent(lblAdminSection))
						
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(149)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(btnCreateUserAccount, GroupLayout.PREFERRED_SIZE,  170, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnViewUserAccount, GroupLayout.PREFERRED_SIZE,  170, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdateUserAccount, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSuspendUserAccount, GroupLayout.PREFERRED_SIZE,170, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSearchUserAccount, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							
							.addComponent(btnCreateUserProfile, GroupLayout.PREFERRED_SIZE,  170, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnViewUserProfile, GroupLayout.PREFERRED_SIZE,  170, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdateUserProfile, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSuspendUserProfile, GroupLayout.PREFERRED_SIZE,170, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSearchUserProfile, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(136, Short.MAX_VALUE))
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addComponent(lblAdminSection)
				.addGap(29)
				.addComponent(btnCreateUserAccount, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnViewUserAccount, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnUpdateUserAccount, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnSuspendUserAccount, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnSearchUserAccount, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				
				.addComponent(btnCreateUserProfile, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnViewUserProfile, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnUpdateUserProfile, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnSuspendUserProfile, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnSearchUserProfile, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addGap(18)

				.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(59, Short.MAX_VALUE))
	);
	contentPane.setLayout(gl_contentPane);
}
}