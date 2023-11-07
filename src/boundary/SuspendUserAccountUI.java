package boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.SuspendUserAccountController;

public class SuspendUserAccountUI  extends JFrame {
    private SuspendUserAccountController controller;
    private JTextField usernameField;
    private JButton deleteButton;
    

    public SuspendUserAccountUI(SuspendUserAccountController controller) {
        this.controller = controller;
        
        setTitle("Delete User Account");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameField = new JTextField(20);
        deleteButton = new JButton("Delete User");

        deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				controller.deleteUserAccount(username);				
			}
        });
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(deleteButton);
        panel.add(btnBack);

        add(panel);
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}