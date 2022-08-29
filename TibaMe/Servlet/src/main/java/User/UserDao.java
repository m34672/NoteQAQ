package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDao {

	private static DataSource ds = null;
	private static UserSQL sql = null;
	Map<String, Object> map = null;
	List<UserVO> list = null;
	UserVO UserVO = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Test");
			sql = new UserSQL();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取得全部
	 */
	public Map<String, Object> getAll() {
		map = new HashMap<>();
		list = new ArrayList<UserVO>();

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql.GET_ALL);) {
			System.out.println("連線成功");
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					UserVO = new UserVO();
					UserVO.setUserNo(rs.getInt("USER_ID"));
					UserVO.setUserName(rs.getString("USER_NAME"));
					UserVO.setUserAge(rs.getInt("USER_AGE"));
					list.add(UserVO);
				}
			}

			map.put("data", list);
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			map.clear();
			map.put("error", e.toString());
			return map;
		}
	}

	/*
	 * 指定ID
	 */
	public Map<String, Object> getId(Integer id) {
		map = new HashMap<>();
		list = new ArrayList<UserVO>();

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql.GET_ID);) {
			System.out.println("連線成功");
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					UserVO = new UserVO();
					UserVO.setUserNo(rs.getInt("USER_ID"));
					UserVO.setUserName(rs.getString("USER_NAME"));
					UserVO.setUserAge(rs.getInt("USER_AGE"));
					list.add(UserVO);
				}
			}

			map.put("data", list);
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			map.clear();
			map.put("error", e.toString());
			return map;
		}
	}

	/**
	 * 新增
	 */
	public Map<String, Object> insert(String name, Integer age) {
		map = new HashMap<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql.INSERT);) {
			System.out.println("連線成功");

			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.executeUpdate();
			map.put("data", "success");

			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			map.clear();
			map.put("error", e.toString());

			return map;
		}
	}

	/**
	 * 刪除
	 */
	public Map<String, Object> delete(Integer id) {
		map = new HashMap<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql.DELETE);) {
			System.out.println("連線成功");

			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			map.put("data", "success");

			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			map.clear();
			map.put("error", e.toString());
			return map;
		}
	}
}
