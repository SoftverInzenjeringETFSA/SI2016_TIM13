package dao;

import javax.sql.DataSource;
import Models.Korisnik;


//data access object interface

public interface KorisnikDAO {
	
	public void setDataSource(DataSource ds);
	
	public void create(String userName, String email, String password);
	
	public Korisnik getKorisnik(String email);
	
	public void update(String email, String newUserName, String newEmail, String newPassword);
	
	public void delete(String userName);

}
