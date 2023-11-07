package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.ViewBidsController;
import controller.ViewWorkslotsController;
import entity.WorkSlot;
import entity.Bid;

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

public class CafeStaffDashboardUI extends JFrame {
	private JPanel contentPane;
	Bid bid = new Bid();
	WorkSlot workslot = new WorkSlot();
	ViewWorkslotsController viewWorkSlotsController = new ViewWorkslotsController(workslot);
	ViewBidsController viewBidsController = new ViewBidsController(bid);

	public CafeStaffDashboardUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 10, 480, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JLabel lblCafeStaffSection = new JLabel("Cafe Staff Dashboard");
		lblCafeStaffSection.setForeground(Color.DARK_GRAY);
		lblCafeStaffSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnViewWorkslots = new JButton("View workslots");
		btnViewWorkslots.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ViewWorkslotsUI viewWorkslotsUI = new ViewWorkslotsUI(viewWorkSlotsController);
				viewWorkslotsUI.setVisible(true);
			}
		});
	
		JButton btnViewBids = new JButton("View bids");
		btnViewBids.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ViewBidsUI viewBidsUI = new ViewBidsUI(viewBidsController);
				viewBidsUI.setVisible(true);
			}
		});
		
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
	    gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup()
	            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                .addGroup(gl_contentPane.createSequentialGroup()
	                    .addGap(120)
	                    .addComponent(lblCafeStaffSection))
	                .addGroup(gl_contentPane.createSequentialGroup()
	                    .addGap(149)
	                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	                        .addComponent(btnViewWorkslots, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(btnViewBids, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
	                )
	            )
	            .addContainerGap(136, Short.MAX_VALUE)
	        )
	);
	gl_contentPane.setVerticalGroup(
	    gl_contentPane.createParallelGroup(Alignment.LEADING)
	        .addGroup(gl_contentPane.createSequentialGroup()
	            .addComponent(lblCafeStaffSection)
	            .addGap(29)
	            .addComponent(btnViewWorkslots, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	            .addGap(18)
	            .addComponent(btnViewBids, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
	            .addContainerGap(59, Short.MAX_VALUE)
	        )
	);
	contentPane.setLayout(gl_contentPane);
	}
}
