package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String parola) {
		
		String sql = "SELECT nome FROM parola WHERE nome = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				st.close();
				conn.close();
				return true;
			}else {
				st.close();
				conn.close();
				return false;
			}
			
		}catch(SQLException sqe) {
			
			sqe.printStackTrace();
			throw new RuntimeException("SQL eccezione", sqe);
		}

	}
}
