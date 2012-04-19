package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import domain.Ahenstvo;
import dao.DataAccessUtil;
public class AhenstvoDao {

	
	private static final String INSERT_QUERY = "insert into ahenstvo " +
			"(Nazva_Tur_Ah, Adresa, Imja_Vlas, Tel_nomer, Fax_nomer, " +
			"Clients_nomber, Ocenka) values (?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_QUERY = "update ahenstvo " +
			"set Nazva_Tur_Ah = ?, Adresa = ?, Imja_Vlas = ?, Tel_nomer = ?," +
			"Fax_nomer = ?, Clients_nomber = ?, Ocenka = ? " +
			"where AhenstvoId = ?";
	private static final String DELETE_QUERY = "delete from ahenstvo where AhenstvoId = ?";
	private static final String SELECT_QUERY = "select AhenstvoId, Nazva_Tur_Ah, Adresa, " +
			"Imja_Vlas, Tel_nomer, Fax_nomer, Clients_nomber, Ocenka " +
			"from ahenstvo where AhenstvoId = ?";
	private static final String SELECT_QUERY_BYNAME = "select AhenstvoId, Nazva_Tur_Ah, Adresa, " +
			"Imja_Vlas, Tel_nomer, Fax_nomer, Clients_nomber, Ocenka " +
	"from ahenstvo where Nazva_Tur_Ah = ?";
	private static final String SELECT_ALL_QUERY = "select AhenstvoId, Nazva_Tur_Ah, Adresa, " +
			"Imja_Vlas, Tel_nomer, Fax_nomer, Clients_nomber, Ocenka " +
			"from ahenstvo";

	public int insertAhenstvo(Ahenstvo ahenstvo) throws Exception {
		
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
		
		try {
			statement.setString(1, ahenstvo.getNazva_Tur_Ah());
			statement.setString(2, ahenstvo.getAdresa());
			statement.setString(3, ahenstvo.getImja_Vlas());
			statement.setInt(4, ahenstvo.getTel_nomer());
			statement.setInt(5, ahenstvo.getFax_nomer());
			statement.setInt(6, ahenstvo.getClients_nomber());
			statement.setString(7, ahenstvo.getOcenka());
			
			statement.executeUpdate();
			
			return DataAccessUtil.getNewRowKey(statement);
		}
		finally {
			DataAccessUtil.close(connection);
		}
	}
	
	public void updateAhenstvo(Ahenstvo ahenstvo) throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
		
		try {
			statement.setString(1, ahenstvo.getNazva_Tur_Ah());
			statement.setString(2, ahenstvo.getAdresa());
			statement.setString(3, ahenstvo.getImja_Vlas());
			statement.setInt(4, ahenstvo.getTel_nomer());
			statement.setInt(5, ahenstvo.getFax_nomer());
			statement.setInt(6, ahenstvo.getClients_nomber());
			statement.setString(7, ahenstvo.getOcenka());
			
			statement.setInt(8, ahenstvo.getId());
			
			statement.executeUpdate();
		}
		finally {
			DataAccessUtil.close(connection);
		}
	}
	
	public void deleteAhenstvo(int groupId) throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
		
		try {
			statement.setInt(1, groupId);
			statement.executeUpdate();
		}
		finally {
			DataAccessUtil.close(connection);
		}
	}
	
	public Ahenstvo findById(int groupId) throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
		
		try {
			statement.setInt(1, groupId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return getAhenstvoFromRow(rs);
			}
			return null;
		}
		finally {
			DataAccessUtil.close(connection);
		}
	}
	public Ahenstvo findBy_Name(String groupName) throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(SELECT_QUERY_BYNAME);
		
		try {
			statement.setString(1, groupName);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return getAhenstvoFromRow(rs);
			}
			return null;
		}
		finally {
			DataAccessUtil.close(connection);
		}
	}
	
	public List<Ahenstvo> findAll() throws Exception {
		Connection connection = DataAccessUtil.createConnection();
		PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
		
		try {
			ResultSet rs = statement.executeQuery();
			List<Ahenstvo> result = new ArrayList<Ahenstvo>();
			while (rs.next()) {
				result.add(getAhenstvoFromRow(rs));
			}
			return result;
		}
		finally {
			DataAccessUtil.close(connection);
		}
	}
	
	private Ahenstvo getAhenstvoFromRow(ResultSet rs) throws Exception {
		Ahenstvo ahenstvo = new Ahenstvo();
		ahenstvo.setId(rs.getInt(1));
		ahenstvo.setNazva_Tur_Ah(rs.getString(2));
		ahenstvo.setAdresa(rs.getString(3));
		ahenstvo.setImja_Vlas(rs.getString(4));
		ahenstvo.setTel_nomer(rs.getInt(5));
		ahenstvo.setFax_nomer(rs.getInt(6));
		ahenstvo.setClients_nomber(rs.getInt(7));
		ahenstvo.setOcenka(rs.getString(8));
		
		return ahenstvo;
	}
}
