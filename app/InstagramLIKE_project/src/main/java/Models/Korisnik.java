package Models;

public class Korisnik {
	
	private int id;
	private String userName;
	private String email;
	private String password;
	private String description;
	
	public Korisnik(){
		this.id = 0;
		this.userName = "";
		this.email = "";
		this.password = "";
		this.description = "";
	}
	
	public Korisnik(int id, String userName, String email, String password, String description) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.description = description;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.userName + " " + this.email + " " + this.password;
	}

}
