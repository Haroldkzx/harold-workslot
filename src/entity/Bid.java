package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Bid {
	private String startTime;
    private String endTime;
    private String date;
    private String role;
    private String status;
    private final String DB_URL = "jdbc:mysql://localhost:3308/csci322";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";
	
	//CRUDS
	
	public void createBid(){
		
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	 public List<WorkSlot> view(){
			List<WorkSlot> list=new ArrayList<>();
			try{
				Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement ps=con.prepareStatement("select * from workslots");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					WorkSlot a=new WorkSlot();
					
					a.setId(rs.getInt(1));
					a.setStartTime(rs.getString(2));
					a.setEndTime(rs.getString(3));
					a.setDate(rs.getString(4));
					a.setRequiredChef(rs.getInt(5));
					a.setRequiredCashier(rs.getInt(6));
					a.setRequiredWaiter(rs.getInt(7));
					list.add(a);
				}
				con.close();
			}catch(Exception e){System.out.println(e);}
			return list;
		}
	
	public void viewBid(){
		
	}
	public void updateBid(){
		
	}
	public void suspendBid(){
		
	}
	public void searchBid(){
		
	}
	
	//Accept/Reject
	public void acceptBid(){
		
	}
	public void rejectBid(){
		
	}
	
}
