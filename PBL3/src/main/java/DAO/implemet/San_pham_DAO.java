package DAO.implemet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.JDBC_Unit;
import DAO.AbstractDao;
import DAO.getList_DAO;
import Entity.San_Pham.San_pham;
import Mapper.San_Pham.San_pham_Mapper;

public class San_pham_DAO extends AbstractDao implements getList_DAO{
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getList(String query, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<T> list = new ArrayList<T>();
		try {
			connection = JDBC_Unit.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(query);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			connection.commit();
			
			while(resultSet.next()) {
				T t = (T) resultSet.getObject("duong_dan_anh");
				list.add(t);
			}
			
			return list;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	
	public List<San_pham> getList_San_Pham(String query){
		List<San_pham> list_san_pham = new AbstractDao().query(query, new San_pham_Mapper());
		
		query = "select duong_dan_anh from anh_san_pham where id_san_pham = ?";
		List<String> list = null;
		
		for(int i = 0; i < list_san_pham.size(); ++i) {
			list = getList(query, list_san_pham.get(i).getId_san_pham());
			list_san_pham.get(i).setAnh_san_pham(list);
		}
		return list_san_pham;
	}
}
