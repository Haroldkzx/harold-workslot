package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ViewWorkslotsController;
import entity.User;
import entity.UserAccount;
import entity.WorkSlot;

public class ViewWorkslotsUI extends JFrame {
	
	private ViewWorkslotsController controller;
	public ViewWorkslotsUI(ViewWorkslotsController viewWorkSlotsController) {
		this.controller = viewWorkSlotsController;

		List<WorkSlot> list = viewWorkSlotsController.viewWorkSlot();
		int size = list.size();

		String data[][] = new String[size][7];
		int row = 0;
		for (WorkSlot a : list) {

			data[row][0] = a.getStartTime();
			data[row][1] = a.getEndTime();
			data[row][2] = a.getDate();
			data[row][3] = Integer.toString(a.getRequiredCashier());
			data[row][4] = Integer.toString(a.getRequiredChef());
			data[row][5] = Integer.toString(a.getRequiredWaiter());
			
			row++;

		}
		String columnNames[] = { "Start time", "End time", "Date", "Required Cashiers", "Required Chefs",
				"Required Waiters", "Actions" };

		JTable jt = new JTable(data, columnNames);
		JScrollPane sp = new JScrollPane(jt);
		add(sp);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}
}
