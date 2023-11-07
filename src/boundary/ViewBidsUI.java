package boundary;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ViewBidsController;
import entity.WorkSlot;
import entity.Bid;
import entity.UserAccount;

public class ViewBidsUI extends JFrame {
	
	private ViewBidsController controller;
	public ViewBidsUI(ViewBidsController viewBidsController) {
		this.controller = viewBidsController;
		
		//View JTable
		List<Bid> list = viewBidsController.viewBids();
		int size = list.size();
		
		String data[][]=new String[size][5];
		int row=0;
		for(Bid a:list) {
			data[row][0]=a.getStartTime();
			data[row][1]=a.getEndTime();
			data[row][2]=a.getDate();
			data[row][3]=a.getRole();
			data[row][4]=a.getStatus();
			
			row++;
		}
		String columnNames[]= {"Start Time","End Time","Date","Role","Status"};
		
		JTable jt=new JTable(data,columnNames);
		JScrollPane sp=new JScrollPane(jt);
		add(sp);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		}
}
