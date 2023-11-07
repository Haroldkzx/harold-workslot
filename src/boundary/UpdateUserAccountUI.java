package boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.UpdateUserAccountController;
import entity.User;
import entity.UserAccount;
import entity.UserAccount;
import entity.UserDAO;



public class UpdateUserAccountUI extends JFrame{
	
	private UpdateUserAccountController controller;
//	static UpdateUserAccountUI  frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JTextArea textArea;
	private JTextField textField_10;

	
	public UpdateUserAccountUI(UpdateUserAccountController controller) {
    	this.controller= controller;
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 450, 550);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);

	    GroupLayout layout = new GroupLayout(contentPane);
	    contentPane.setLayout(layout);
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 550);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		
		//Labels
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JLabel lblDOB = new JLabel("Date of Birth:");
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		
		JLabel lblAddress = new JLabel("Address:");
		
		JLabel lblUserProfile = new JLabel("User Profile:");
		//Update Button
		JButton btnUpdateUserAccount = new JButton("Update");
		btnUpdateUserAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String password=textField_1.getText();
				String DOB=textField_2.getText();
				String emailAddress=textField_3.getText();
				String address=textField_4.getText();
				String userProfile=textField_5.getText();
								
				int ID=Integer.parseInt(textField_10.getText());				

				UserAccount u=new UserAccount(name,ID,password,DOB,emailAddress,address,userProfile);
				int status=controller.updateUserAccount(u);//
				
				if(status>0){
					JOptionPane.showMessageDialog(UpdateUserAccountUI.this,"User Account updated successfully!");
//					AccountantSection.main(new String[]{});
//					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(UpdateUserAccountUI.this,"Sorry, Unable to update the user account!");
				}
			}
		});
		//TextField
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
				
//		textArea = new JTextArea();
		//Back Button
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblUserID= new JLabel("User ID");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		


		JSeparator separator = new JSeparator();
		
		JButton btnLoadRecord = new JButton("Load Record");
		btnLoadRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String IDno=textField_10.getText();
				if( IDno==null|| IDno.trim().equals("")){
					JOptionPane.showMessageDialog(UpdateUserAccountUI.this,"Please enter id no first!");
				}else{
				int ID =Integer.parseInt(IDno);
				UserAccount u= controller.getUserAccountByIDno(ID);//
				
				textField.setText(u.getUserName());
				textField_1.setText(u.getPassword());
				textField_2.setText(u.getDateOfBirth());
				textField_3.setText(u.getEmailAddr());
				textField_4.setText(u.getAddress());
				textField_5.setText(u.getUserProfile());

				}
			}
		});
		// Create a sequential group for the horizontal axis
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblUserID)
                .addComponent(lblName)
                .addComponent(lblPassword)
                .addComponent(lblDOB)
                .addComponent(lblEmailAddress)
                .addComponent(lblAddress)
                .addComponent(lblUserProfile)

        );
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(textField_10)
                .addComponent(textField)
                .addComponent(textField_1)
                .addComponent(textField_2)
                .addComponent(textField_3)
                .addComponent(textField_4)
                .addComponent(textField_5)

        );
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(btnLoadRecord)
                .addComponent(btnUpdateUserAccount)
                .addComponent(btnBack)

        );
        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblUserID)
                .addComponent(textField_10)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblName)
                .addComponent(textField)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblPassword)
                .addComponent(textField_1)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblDOB)
                .addComponent(textField_2)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblEmailAddress)
                .addComponent(textField_3)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblAddress)
                .addComponent(textField_4)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblUserProfile)
                .addComponent(textField_5)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnLoadRecord)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnUpdateUserAccount)
        );
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(btnBack)
        );
        layout.setVerticalGroup(vGroup);

        pack(); // Auto-size the frame
        setLocationRelativeTo(null); // Center the frame on the screen
    }
 }	

