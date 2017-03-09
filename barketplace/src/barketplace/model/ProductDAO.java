package barketplace.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import barketplace.model.dto.ProductDTO;
import barketplace.model.util.DBUtil;

public class ProductDAO {

	// Product Insert
	public static boolean addProduct(ProductDTO Product) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into product(product_name, brand_name)" + "values(?,?)");
			pstmt.setString(1, Product.getProductName());
			pstmt.setString(2, Product.getBrandName());
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// Product Find
	public static ProductDTO getProduct(String ProductName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProductDTO Product = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from product where product_name = ?");
			pstmt.setString(1, ProductName);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Product = new ProductDTO(rset.getString(1), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return Product;
	}

	// All Brand Search
	public static ArrayList<String> getAllBrand() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select brand_name from product");
			rset = pstmt.executeQuery();

			list = new ArrayList<String>();
			while (rset.next()) {
				list.add(rset.getString(1));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	// Brand - Product Search
	public static ArrayList<String> getBrandProduct(String brandName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select product_name from product where brand_name = ? ");
			pstmt.setString(1, brandName);
			rset = pstmt.executeQuery();

			list = new ArrayList<String>();
			while (rset.next()) {
				list.add(rset.getString(1));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// All Product Search
	public static ArrayList<ProductDTO> getAllProduct() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from product");
			rset = pstmt.executeQuery();

			list = new ArrayList<ProductDTO>();
			while (rset.next()) {
				list.add(new ProductDTO(rset.getString(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	// product Delete
	public static boolean deleteProduct(String product_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from product where product_name=?");
			pstmt.setString(1, product_name);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
