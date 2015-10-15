package com.sis.historiasClinicas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class SISPersistence {
	private Connection con;
	private Statement stmt;
	private MysqlDataSource ds;

	public SISPersistence() {
		ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://157.253.236.94:3306/SISDB");
		ds.setUser("root");
		ds.setPassword("Estudiante1");
	}

	public void conectar() {
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String dummyService() {
		ResultSet rs = null;
		String response = "";
		try {
			rs = stmt.executeQuery("SELECT * FROM Test");
			while (rs.next()) {
				response += "ID=" + rs.getInt("id") + ", Name="
						+ rs.getString("nombre") + "\n";
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

	public JSONArray historiasClinicasService() {
		ResultSet rs = null;
		JSONArray response = new JSONArray();
		try {
			rs = stmt.executeQuery("SELECT * FROM HISTORIAS_CLINICAS");
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

	public JSONArray historiasClinicasByIdService(int id) {
		ResultSet rs = null;
		JSONArray response = new JSONArray();
		try {
			rs = stmt
					.executeQuery("SELECT * FROM HISTORIAS_CLINICAS WHERE idPaciente="
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