package boundary;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.CreateUserAccountController;
import entity.UserAccount;


public class CreateUserAccountUI extends JFrame{
	
	private CreateUserAccountController controller;
	private JTextField usernameField;
    private JPasswordField passwordField;
	private JTextField IDField;
    private JComboBox c1;
    private JTextField DOBField ;
    private JTextField EmailAddressField;
    private JTextField AddressField;
    
    public CreateUserAccountUI(CreateUserAccountController controller) {
    	this.controller= controller;
    	
    	
    	setTitle("Create User Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(400, 10, 480, 700);
        setLayout(new GridLayout(9, 2));

        JLabel usernameLabel = new JLabel("Enter username: ");
        usernameField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Enter password: ");
        passwordField = new JPasswordField();
        
        JLabel IDLabel = new JLabel("Enter ID: ");
        IDField = new JTextField();
        
        JLabel userTypeLabel = new JLabel("Enter UserType: ");
        c1 = new JComboBox(new String[]{"System Admin","Cafe Owner","Cafe Manager","Cafe Staff"});
        
        JLabel DOBLabel = new JLabel("Enter Date OF Birth: ");
        DOBField = new JTextField();
        
        JLabel EmailAddrLabel = new JLabel("Enter EmailAddress: ");
        EmailAddressField = new JTextField();
        
        JLabel AddrLabel = new JLabel("Enter Address: ");
        AddressField = new JTextField();
        
        

        JButton createUserButton = new JButton("Submit");

        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                //Validate inputs (e.g., check for empty fields)
                if (usernameField.getText().isEmpty() ||new String(passwordField.getPassword()).isEmpty()) {
                    // Show an error message to the user
                    JOptionPane.showMessageDialog(null, "Username and password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method
                }
                
            	UserAccount u=new UserAccount(usernameField.getText(),
            								Integer.parseInt(IDField.getText()),
            								new String(passwordField.getPassword()),
            								DOBField.getText(),
            								EmailAddressField.getText(),
            								AddressField.getText(),
            								c1.getSelectedItem().toString()
            			);
            	boolean created = controller.createUserAccount(u);
            	if (created) {
            		// Display a success message
            		JOptionPane.showMessageDialog(null, "User account created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            	} else {
            		// Handle errors, such as a failed database operation
            		JOptionPane.showMessageDialog(null, "Failed to create the user account", "Error", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
        JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(IDLabel);
        add(IDField);
        add(userTypeLabel);
        add(c1);
        add(DOBLabel);
        add(DOBField);
        add(EmailAddrLabel);
        add(EmailAddressField);
        add(AddrLabel);
        add(AddressField);
        add(new JLabel()); // Empty label for spacing
        add(createUserButton);
        add(new JLabel()); // Empty label for spacing
        add(btnBack);
    	
    }
	
	

}
