package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  UserAccount {
	private String userName;
	private int id;
	private String password;
	private String dateOfBirth;
	private String emailAddr;
	private String address;
	private String userProfile;
    private final String DB_URL = "jdbc:mysql://localhost:3308/csci322";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";
    
    public UserAccount(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
            
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public UserAccount(String userName, int id, String password, String dateOfBirth, String emailAddr,String address,String userProfile) {
		this.userName = userName;
		this.id = id;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.emailAddr = emailAddr;
		this.address = address;
		this.userProfile = userProfile;
	}
	//getters and setters
	public String getUserName() {
		return userName;
	}
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public String getAddress() {
		return address;
	}
	public String getUserProfile() {
		return userProfile;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	
    public boolean createUser(UserAccount userAccount) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        

        try {
            // Establish a database connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Insert the user into the database
            String insertQuery = "INSERT INTO useraccount (user_name,user_id,user_password,date_of_birth, email_address, address,user_profile) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, userAccount.getUserName());
            preparedStatement.setInt(2, userAccount.getId());  
            preparedStatement.setString(3, userAccount.getPassword());
//          preparedStatement.setDate(5, java.sql.Date.valueOf(userAccount.getDateOfBirth()));  // Assuming dateOfBirth is a java.util.Date or LocalDate
            preparedStatement.setString(4, userAccount.getDateOfBirth());
            preparedStatement.setString(5, userAccount.getEmailAddr());
            preparedStatement.setString(6, userAccount.getAddress());
            preparedStatement.setString(7, userAccount.getUserProfile());
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
    public List<UserAccount> view(){
		List<UserAccount> list=new ArrayList<>();
		try{
			Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement ps=con.prepareStatement("select * from useraccount");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserAccount a=new UserAccount();
				
				a.setUserName(rs.getString(1));
				a.setId(rs.getInt(2));
				a.setPassword(rs.getString(3));
				a.setDateOfBirth(rs.getString(4));
				a.setEmailAddr(rs.getString(5));
				a.setAddress(rs.getString(6));
				a.setUserProfile(rs.getString(7));
				list.add(a);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
    public int update(UserAccount u) {
        int status = 0;
        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //SQL query with 6 placeholders and 7 parameters
            PreparedStatement ps = con.prepareStatement("update useraccount set user_name=?, user_password=?, date_of_birth=?, email_address=?, address=?, user_profile=? where user_id=?");
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getDateOfBirth());
            ps.setString(4, u.getEmailAddr());
            ps.setString(5, u.getAddress());
            ps.setString(6, u.getUserProfile());
            ps.setInt(7, u.getId());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public UserAccount getUserAccountByIDno(int ID){
		UserAccount u=new UserAccount();
		try{
			Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement ps=con.prepareStatement("select * from useraccount where user_id=?");
			ps.setInt(1,ID);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				u.setUserName(rs.getString("user_name"));
				u.setId(rs.getInt("user_id"));
				u.setPassword(rs.getString("user_password"));
				u.setDateOfBirth(rs.getString("date_of_birth"));
				u.setEmailAddr(rs.getString("email_address"));
				u.setAddress(rs.getString("address"));
				u.setUserProfile(rs.getString("user_profile"));
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return u;
	}
    public boolean deleteUserByUsername(String username) {
           String deleteSQL = "DELETE FROM useraccount WHERE user_name = ?";
        
        	try {
        	Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        	PreparedStatement ps=con.prepareStatement(deleteSQL);
            ps.setString(1, username);
            int rowsAffected = ps.executeUpdate();

            // Check if the delete operation was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or log it
            return false; // Return false to indicate failure
        }
    }
    public List<UserAccount> searchUserAccount(String username) {
        List<UserAccount> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM useraccount WHERE user_name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username); // Set the username parameter
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserAccount a = new UserAccount();
                a.setUserName(rs.getString("user_name")); // Use column names or indices
                a.setId(rs.getInt("user_id"));
                a.setPassword(rs.getString("user_password"));
                a.setDateOfBirth(rs.getString("date_of_birth"));
                a.setEmailAddr(rs.getString("email_address"));
                a.setAddress(rs.getString("address"));
                a.setUserProfile(rs.getString("user_profile"));
                list.add(a);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Properly handle or log the exception
        }
        return list;
    }
    public boolean authenticateUserAccount(String username,String password) {
        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM useraccount WHERE user_name=? && user_password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username); // Set the username parameter
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	return true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Properly handle or log the exception
        }
		return false;
    }



    
}