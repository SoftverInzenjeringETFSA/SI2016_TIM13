package ModelMappers;

import Models.Korisnik;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KorisnikMapper implements RowMapper<Korisnik> {

	@Override
	public Korisnik mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		return new Korisnik(resultSet.getInt("korisnik_id"),
							resultSet.getString("korisnicko_ime"), 
							resultSet.getString("email"), 
							resultSet.getString("korisnicka_sifra_hash"),
							resultSet.getString("kratak_opis"));
	}

}
