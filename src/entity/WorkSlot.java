package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkSlot {
    private int id;
    private String startTime;
    private String endTime;
    private String date;
    private int requiredChef;
    private int requiredCashier;
    private int requiredWaiter;
//    private String status; 
    private final String DB_URL = "jdbc:mysql://localhost:3308/csci322";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";
    
    public WorkSlot(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
            
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // Constructors, getters, and setters
    public WorkSlot(int id, String startTime, String endTime, String date,int requiredChef, int requiredCashier, int requiredWaiter) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
//        this.requiredStaff = requiredStaff;
//        this.status = status;
        this.requiredChef=requiredChef;
        this.requiredCashier=requiredCashier;
        this.requiredWaiter=requiredWaiter;
        
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public int getRequiredChef() {
		return requiredChef;
	}

	public int getRequiredCashier() {
		return requiredCashier;
	}

	public int getRequiredWaiter() {
		return requiredWaiter;
	}

	public void setRequiredChef(int requiredChef) {
		this.requiredChef = requiredChef;
	}

	public void setRequiredCashier(int requiredCashier) {
		this.requiredCashier = requiredCashier;
	}

	public void setRequiredWaiter(int requiredWaiter) {
		this.requiredWaiter = requiredWaiter;
	}
	//CRUDS by cafeOwners
    public boolean createWorkSlot(WorkSlot workSlot) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish a database connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Insert the work slot into the database
            String insertQuery = "INSERT INTO workslots (id, start_time, end_time, date, requiredChef, requiredCashier, requiredWaiter) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setInt(1, workSlot.getId());
            preparedStatement.setString(2, workSlot.getStartTime());
            preparedStatement.setString(3, workSlot.getEndTime());
            preparedStatement.setString(4, workSlot.getDate());
            preparedStatement.setInt(5, workSlot.getRequiredChef());
            preparedStatement.setInt(5, workSlot.getRequiredCashier());
            preparedStatement.setInt(5, workSlot.getRequiredWaiter());
//            preparedStatement.setString(6, workSlot.getStatus());
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    //Continue
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

	public void viewWorkSlots(){
		
	}
	public void updateWorkSlots(){
		
	}
	public void suspendWorkSlots(){
		
	}
	public void searchWorkSlots(){
		
	}
	public void selectMaxWorkSlots() {
		
		
	}
	public void assignStaff(){
	}
	

}
