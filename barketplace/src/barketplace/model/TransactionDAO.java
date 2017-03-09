package barketplace.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import barketplace.model.dto.ProductDTO;
import barketplace.model.dto.TransactionDTO;
import barketplace.model.util.DBUtil;

public class TransactionDAO {
	// 판매글 게시
	public static boolean addTransaction(TransactionDTO Transaction) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"insert into transaction(trans_no,sell_id,brand_name,product_name,coupon_barcode,price,exp_date,content) "
							+ "values(seq_trans_no.nextval,?,?,?,?,?,?,?)");
			pstmt.setString(1, Transaction.getSellId());
			pstmt.setString(2, Transaction.getBrandName());
			pstmt.setString(3, Transaction.getProductName());
			pstmt.setString(4, Transaction.getCouponBarcode());
			pstmt.setInt(5, Transaction.getPrice());
			pstmt.setString(6, Transaction.getExpDate());
			pstmt.setString(7, Transaction.getContent());
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 판매중 게시글 상세보기(이력)
	public static TransactionDTO getTransaction(int trans_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TransactionDTO Transaction = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(
					"select trans_no, price, proceed, sell_id, brand_name, product_name, exp_date, content, calender from transaction where trans_no = ?");
			pstmt.setInt(1, trans_no);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Transaction = new TransactionDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return Transaction;
	}

	// 모든 게시글 가져오기
	public static ArrayList<TransactionDTO> getAlLTransaction() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<TransactionDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from transaction");
			rset = pstmt.executeQuery();

			list = new ArrayList<TransactionDTO>();
			while (rset.next()) { // rset.getInt(7) : proceed
				list.add(new TransactionDTO(rset.getInt(1), rset.getInt(7), rset.getInt(11), rset.getString(2),
						rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(8),
						rset.getString(9), rset.getString(10)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// 구매를 요청한 거래에 구매자 입력
	public static boolean updateTransaction(int trans_no, String buyId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update transaction set buy_id=?, proceed = 1 where trans_no=?");
			pstmt.setString(1, buyId);
			pstmt.setInt(2, trans_no);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 주문 취소
	public static boolean cancelTransaction(int trans_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update transaction set proceed = 0 where trans_no=?");
			pstmt.setInt(1, trans_no);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// Transaction Delete
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
