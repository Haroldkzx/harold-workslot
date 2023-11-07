package boundary;
import javax.swing.*;
import controller.LoginController;
import entity.UserAccount;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private LoginController loginController;
    private JTextField usernameField;
    private JPasswordField passwordField;
    //


    public LoginUI(LoginController controller) {
        this.loginController = controller;

        setTitle("Login Page");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel());
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (loginController.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(LoginUI.this, "Login successful. Welcome, " + username + "!");                    
        			dispose();
                    //
//                	SystemAdminDashboardUI systemAdminDashboardUI=new SystemAdminDashboardUI();
//                	systemAdminDashboardUI.setVisible(true);
                	
//                    CafeOwnerDashboardUI cafeOwnerDashboardUI=new CafeOwnerDashboardUI();
//                    cafeOwnerDashboardUI.setVisible(true);
                	
                	CafeStaffDashboardUI cafeStaffDashboardUI=new CafeStaffDashboardUI();
                	cafeStaffDashboardUI.setVisible(true);
                    
                    
                } else {
                    JOptionPane.showMessageDialog(LoginUI.this, "Login failed. Please check your credentials.");
                }
            }
        }
        );
    }

    public static void main(String[] args) {
        UserAccount userAccount = new UserAccount();
        LoginController loginController = new LoginController(userAccount);
        LoginUI loginGUI = new LoginUI(loginController);
        loginGUI.setVisible(true);
    }
}
