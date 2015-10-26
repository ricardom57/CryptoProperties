package com.sis.historiasClinicas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class SISPersistence {
	private static Connection con;
	private static Statement stmt;
	private static MysqlDataSource ds;
	static {
		ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://sisa.cf6qs3skpbuq.us-west-2.rds.amazonaws.com:3306/SIS");
		ds.setUser("jmtoro10");
		ds.setPassword("12345678");

		try {
			con = ds.getConnection();
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static JSONArray historiasClinicasService() {
		ResultSet rs = null;
		JSONArray response = new JSONArray();
		try {
			rs = stmt.executeQuery("SELECT * FROM HISTORIA_CLINICA");
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("idPaciente", rs.getInt("idPaciente"));
				obj.put("idConsulta", rs.getInt("idConsulta"));
				obj.put("datosObjetivos", rs.getString("datosObjetivos"));
				obj.put("tipoExamen", rs.getString("tipoExamen"));
				obj.put("medicamento", rs.getString("medicamento"));
				obj.put("tipoMedicamento", rs.getString("tipoMedicamento"));
				obj.put("examen", rs.getString("examen"));
				obj.put("diagnostico", rs.getString("diagnostico"));
				obj.put("tipoConsulta", rs.getString("tipoConsulta"));
				obj.put("tipoFuente", rs.getString("tipoFuente"));
				obj.put("datosSubjetivos", rs.getString("datosSubjetivos"));
				obj.put("pronostico", rs.getString("pronostico"));
				response.put(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return response;
	}

	public static JSONArray historiasClinicasByIdService(int id) {
		ResultSet rs = null;
		JSONArray response = new JSONArray();
		try {
			rs = stmt
					.executeQuery("SELECT * FROM HISTORIA_CLINICA WHERE idPaciente="
							+ id);
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("idPaciente", rs.getInt("idPaciente"));
				obj.put("idConsulta", rs.getInt("idConsulta"));
				obj.put("datosObjetivos", rs.getString("datosObjetivos"));
				obj.put("tipoExamen", rs.getString("tipoExamen"));
				obj.put("medicamento", rs.getString("medicamento"));
				obj.put("tipoMedicamento", rs.getString("tipoMedicamento"));
				obj.put("examen", rs.getString("examen"));
				obj.put("diagnostico", rs.getString("diagnostico"));
				obj.put("tipoConsulta", rs.getString("tipoConsulta"));
				obj.put("tipoFuente", rs.getString("tipoFuente"));
				obj.put("datosSubjetivos", rs.getString("datosSubjetivos"));
				obj.put("pronostico", rs.getString("pronostico"));
				response.put(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return response;
	}
}