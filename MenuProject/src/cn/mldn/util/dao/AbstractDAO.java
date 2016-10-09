package cn.mldn.util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.mldn.util.dbc.DatabaseConnection;

public abstract class AbstractDAO {
	protected Connection conn ;
	protected PreparedStatement pstmt ;
	public AbstractDAO() {
		this.conn = DatabaseConnection.get() ;
	}
	
}
