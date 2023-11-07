package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.CreateWorkSlotController;
import entity.WorkSlot;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
public class CafeOwnerDashboardUI  extends JFrame{
	

	private JPanel contentPane;
	WorkSlot workSlot = new WorkSlot();
	CreateWorkSlotController createWorkSlotController = new CreateWorkSlotController(workSlot);



public CafeOwnerDashboardUI () {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(400, 10, 460, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
	setContentPane(contentPane);
	
	JLabel lblCafeOwnerSection = new JLabel("Cafe Owner Dashboard");
	lblCafeOwnerSection.setForeground(Color.DARK_GRAY);
	lblCafeOwnerSection.setFont(new Font("Tahoma", Font.PLAIN, 20));

	JButton btnCreateWorkSlot = new JButton("Create Work Slot");
	btnCreateWorkSlot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CreateWorkSlotUI createWorkSlotUI=new CreateWorkSlotUI(createWorkSlotController);
			createWorkSlotUI.setVisible(true);
			dispose();
		}
	});
	
	JButton btnViewWorkSlot = new JButton("View Work Slot");
	btnViewWorkSlot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			ViewUserWorkSlotUI viewUserWorkSlotUI = new ViewUserWorkSlotUI();
//			viewUserWorkSlotUI.setVisible(true);
			dispose();
		}
	});
	
	JButton btnUpdateWorkSlot = new JButton("Update Work Slot");
	btnUpdateWorkSlot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			UpdateUserWorkSlotUI updateUserWorkSlotUI = new UpdateUserWorkSlotUI();
//			updateUserWorkSlotUI.setVisible(true);
			dispose();
		}
	});
	
	JButton btnSuspendWorkSlot = new JButton("Suspend Work Slot");
	btnSuspendWorkSlot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//	        SuspendUserWorkSlotUI suspendUserWorkSlotUI = new SuspendUserWorkSlotUI();
//	        suspendUserWorkSlotUI.setVisible(true);
	        dispose();
		}
	});
	
	JButton btnSearchWorkSlot = new JButton("Search Work Slot");
	btnSearchWorkSlot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
//			SearchUserWorkSlotUI searchUserWorkSlotUI = new SearchUserWorkSlotUI();
//			searchUserWorkSlotUI.setVisible(true);
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
	                    .addComponent(lblCafeOwnerSection))

	                .addGroup(gl_contentPane.createSequentialGroup()
	                    .addGap(149)
	                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addComponent(btnCreateWorkSlot, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(btnViewWorkSlot, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(btnUpdateWorkSlot, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(btnSuspendWorkSlot, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(btnSearchWorkSlot, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
	                       	                        
	                        .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
	            .addContainerGap(136, Short.MAX_VALUE))
	);
	gl_contentPane.setVerticalGroup(
	    gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup()
	            .addComponent(lblCafeOwnerSection)
	            .addGap(29)
	            .addComponent(btnCreateWorkSlot, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	            .addGap(18)
	            .addComponent(btnViewWorkSlot, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	            .addGap(18)
	            .addComponent(btnUpdateWorkSlot, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	            .addGap(18)
	            .addComponent(btnSuspendWorkSlot, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	            .addGap(18)
	            .addComponent(btnSearchWorkSlot, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	            .addGap(18)	            
	            .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	            .addContainerGap(59, Short.MAX_VALUE))
	);
	contentPane.setLayout(gl_contentPane);
    setLocationRelativeTo(null);
}

}
