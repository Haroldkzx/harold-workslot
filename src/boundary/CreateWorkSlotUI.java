package boundary;

//public class CreateWorkSlotUI {
//
//	
//}
import javax.swing.*;

import controller.CreateWorkSlotController;
import entity.WorkSlot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateWorkSlotUI extends JFrame {
    private CreateWorkSlotController controller;
    private JTextField idField, startTimeField, endTimeField, dateField, requiredStaffField, statusField;
    private JButton createButton;

    public CreateWorkSlotUI(CreateWorkSlotController controller) {
        this.controller = controller;
        initUI();
    }

    private void initUI() {
        setTitle("Create Work Slot");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Layout
        setLayout(new GridLayout(7, 2, 5, 5)); // Simple grid layout

        // UI Components
        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Start Time (HH:mm):"));
        startTimeField = new JTextField();
        add(startTimeField);

        add(new JLabel("End Time (HH:mm):"));
        endTimeField = new JTextField();
        add(endTimeField);

        add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        add(dateField);

        add(new JLabel("Required Staff:"));
        requiredStaffField = new JTextField();
        add(requiredStaffField);

        add(new JLabel("Status (e.g., Open, Closed):"));
        statusField = new JTextField();
        add(statusField);

        createButton = new JButton("Create Work Slot");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createWorkSlot();
            }
        });
        JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        add(createButton);
        add(btnBack);

        // Set visibility
        pack(); // Adjusts window to fit all components
        setVisible(true);
    }

    private void createWorkSlot() {
        try {
            int id = Integer.parseInt(idField.getText());
            String startTime = startTimeField.getText();
            String endTime = endTimeField.getText();
            String date = dateField.getText();
            int requiredStaff = Integer.parseInt(requiredStaffField.getText());
            String status = statusField.getText();

            WorkSlot workSlot = new WorkSlot(id, startTime, endTime, date, requiredStaff, status);
            boolean created =controller.createWorkSlot(workSlot);

            JOptionPane.showMessageDialog(this, "Work slot created successfully.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID and Required Staff.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

