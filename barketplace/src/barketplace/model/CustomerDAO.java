package barketplace.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import barketplace.model.dto.CustomerDTO;
import barketplace.model.util.DBUtil;

public class CustomerDAO {
	
	//Customer Insert
	public static boolean addCustomer(CustomerDTO Customer) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into customer(id,password,name,phone,bank_name,bank_account) "
					+ "values(?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, Customer.getId());
			pstmt.setString(2, Customer.getPassword());
			pstmt.setString(3, Customer.getName());
			pstmt.setString(4, Customer.getPhone());
			pstmt.setString(5, Customer.getBankName());
			pstmt.setString(6, Customer.getBankAccount());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//CustomerId Find
	public static CustomerDTO getCustomer(String CustomerId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CustomerDTO Customer = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from Customer where customer_id=?");
			pstmt.setString(1, CustomerId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				Customer = new CustomerDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5),rset.getString(6));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return Customer;
	}
	
	//All Customer Search
	public static ArrayList<CustomerDTO> getAllCustomer() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CustomerDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from Customer");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<CustomerDTO>();
			while(rset.next()){
				list.add(new CustomerDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5),rset.getString(6)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	//Customer Delete
	public static boolean deleteCustomer(String CustomerId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from Customer where customer_id=?");
			pstmt.setString(1, CustomerId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//Customer Update

	
}
