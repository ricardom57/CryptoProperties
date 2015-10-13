package com.sis.historiasClinicas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

 
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

	

public class SISDBPool {
	private static MysqlDataSource mysqlDS = null;
	
	static {
        mysqlDS = new MysqlDataSource();
		mysqlDS.setURL("jdbc:mysql://157.253.236.94:3306/SISDB");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("Estudiante1");
    }
	
	public SISDBPool(){

	}
	
	public String testDataSource() {
        DataSource ds = mysqlDS;
         
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String response = "";        
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * FROM Test");
            while(rs.next()){
                response += "ID="+rs.getInt("id")+", Name="+rs.getString("nombre")+"\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
		return response;
    }
}