package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import domain.Tur;
import dao.DataAccessUtil;

public class TurDao {
	
	private static final String INSERT_QUERY = 
		"insert into tur (Ahenstvo_Tur, Nazva_turu, Opus_turu, Data_poch_turu, Truv_turu, " +
		"Kraina, Vartist) " +
		"values (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String UPDATE_QUERY = 
		"update tur " + 
		"set Ahenstvo_Tur = ?, Nazva_turu = ?, Opus_turu = ?, Data_poch_turu = ?, Truv_turu = ?, " +
		"Kraina = ?, Vartist = ?" + 
		"where TurId = ?";
	
	private static final String DELETE_QUERY = 
		"delete from tur where TurId = ?";
	
	private static final String SELECT_QUERY = 
		"select AhenstvoId, Ahenstvo_Tur, Nazva_turu, Opus_turu, Data_poch_turu, Truv_turu, " +
		"Kraina, Vartist" + 
		"from tur where TurId = ?";
	
	private static final String SELECT_ALL_QUERY = 
		"select TurId, Ahenstvo_Tur, Nazva_turu, Opus_turu, Data_poch_turu, Truv_turu, " +
		"Kraina, Vartist  from tur";
	
	public int insertTur(Tur tur) throws Exception {

		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

		try {
			statement.setInt(1, tur.getAhenstvo_Tur());
			statement.setString(2, tur.getNazva_turu());
			statement.setString(3, tur.getOpus_turu());
			statement.setString(4, tur.getData_poch_turu());
			statement.setInt(5, tur.getTruv_turu());
			statement.setString(6, tur.getKraina());
			statement.setString(7, tur.getVartist());

			statement.executeUpdate();

			return DataAccessUtil.getNewRowKey(statement);
		} finally {
			DataAccessUtil.close(connection);
		}
	}

	public void updateTur(Tur tur) throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);

		try {
			statement.setInt(1, tur.getAhenstvo_Tur());
			statement.setString(2, tur.getNazva_turu());
			statement.setString(3, tur.getOpus_turu());
			statement.setString(4, tur.getData_poch_turu());
			statement.setInt(5, tur.getTruv_turu());
			statement.setString(6, tur.getKraina());
			statement.setString(7, tur.getVartist());
			statement.setInt(8, tur.getId());
			
			statement.executeUpdate();
		} finally {
			DataAccessUtil.close(connection);
		}
	}

	public void deleteTur(int tur_Id) throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);

		try {
			statement.setInt(1, tur_Id);
			statement.executeUpdate();
		} finally {
			DataAccessUtil.close(connection);
		}
	}

	public Tur findById(int gamesId) throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);

		try {
			statement.setInt(1, gamesId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return getTurFromRow(rs);
			}
			return null;
		} finally {
			DataAccessUtil.close(connection);
		}
	}

	public List<Tur> findAll() throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);

		try {
			ResultSet rs = statement.executeQuery();
			List<Tur> result = new ArrayList<Tur>();
			while (rs.next()) {
				result.add(getTurFromRow(rs));
			}
			return result;
		} finally {
			DataAccessUtil.close(connection);
		}
	}


	private Tur getTurFromRow(ResultSet rs) throws Exception {
		Tur tur = new Tur();
		tur.setId(rs.getInt(1));
		tur.setAhenstvo_Tur(rs.getInt(2));
		tur.setNazva_turu(rs.getString(3));
		tur.setOpus_turu(rs.getString(4));
		tur.setData_poch_turu(rs.getString(5));
		tur.setTruv_turu(rs.getInt(6));
		tur.setKraina(rs.getString(7));
		tur.setVartist(rs.getString(8));
		
		return tur;
	}

}