package JdbcTemplates;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import Models.MD5;
import ModelMappers.KorisnikMapper;
import Models.Korisnik;
import dao.KorisnikDAO;
import Models.MD5;

public class KorisnikJDBCTemplate implements KorisnikDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject; //ovo referencira bazu i nad njim radim promjene koje se odnose na bazu

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}

	@Override
	public void create(String userName, String email, String password) {
		String sql = "insert into korisnici (korisnicko_ime, email, korisnicka_sifra_hash) values (?, ?, ?)";
		//hesiranje pomocu MD5
		String passMD5 = MD5.getMD5(password);
		
		this.jdbcTemplateObject.update(sql, userName, email, passMD5);
	}

	@Override
	public Korisnik getKorisnik(String email) {
		String sql = "select * from korisnici where email = ?";
		Korisnik korisnik = this.jdbcTemplateObject.queryForObject(sql, new Object[]{email}, new KorisnikMapper());
		
		return korisnik;
	}

	@Override
	public void update(String email, String newUserName, String newEmail, String newPassword) {
		//poslati null ako ne želimo mijenjati neki od atributa osim maila jer on služi za pretragu u bazi
		//jer je jedinstven
		int id = this.getKorisnik(email).getId();
		//nakon što imamo id, možemo mijenjati i user name
		if (newUserName != null) {
			String userSql = "update korisnici set korisnicko_ime = ? where korisnik_id = ?";
			this.jdbcTemplateObject.update(userSql, newUserName, id);
		}
		if (newEmail != null) {
			String emailSql = "update korisnici set email = ? where korisnik_id = ?";
			this.jdbcTemplateObject.update(emailSql, newEmail, id);
		}
		if (newPassword != null) {
			String passwordSql = "update korisnici set korisnicka_sifra_hash = ? where korisnik_id = ?";
			String hash = MD5.getMD5(newPassword);
			this.jdbcTemplateObject.update(passwordSql, hash, id);
		}
	}

	@Override
	public void delete(String email) {
		String sql = "delete from korisnici where email = ?";
		
		this.jdbcTemplateObject.update(sql, email);		
	}

}
