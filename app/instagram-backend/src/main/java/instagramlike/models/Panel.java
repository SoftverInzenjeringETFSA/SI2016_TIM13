package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paneli")
public class Panel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="panel_id")
	private Integer id;
	
	@Column(name="kreator_panela")
	private Integer kreatorID;
	
	@Column(name="privatnost")
	private Integer privatnost;//ovo treba prebaciti u boolean nakon ispravke u bazi
	
	//Constructors
	public Panel() {}
	
	public Panel(Integer kreatorID, Integer privatnost) {
		//thi.id = id;
		this.kreatorID = kreatorID;
		this.privatnost = privatnost;
	}
	
	//Getters
	public Integer getId() {
		return this.id;
	}
	
	public Integer getKreatorID() {
		return this.kreatorID;
	}
	
	public Integer getPrivatnost() {
		return this.privatnost;
	}
	
	//Setters
	/*
	public void setId(Integer id) {
		this.id = id;
	}
	*/
	public void setKreatorID(Integer id) {
		this.kreatorID = id;
	}
	
	public void setPrivatnost(Integer priv) {
		this.privatnost = priv;
	}
	
	//Methods
	@Override
	public String toString() {
		return String.format("{ \"panel_id\": %d, \"kreator_panela_id\": %d, \"privatnost\": %d }",
							this.id, this.kreatorID, this.privatnost);
	}
	
}
