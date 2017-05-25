package instagramlike.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pozivnice_za_panel")
public class PozivnicaZaPanel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pozivnica_id")
	private Integer id;
	
	@Column(name="korisnik_poslao_id")
	private Integer posiljaocID;
	
	@Column(name="korisnik_prima_id")
	private Integer primaocID;
	
	@Column(name="panel_id")
	private Integer panelID;
	
	//Constructors
	public PozivnicaZaPanel() {}
	
	public PozivnicaZaPanel(Integer posiljaocID, Integer primaocID, Integer panelID) {
		//this.id = id
		this.posiljaocID = posiljaocID;
		this.primaocID = primaocID;
		this.panelID = panelID;
	}
	
	//Getters
	public Integer getId() {
		return this.id;
	}
	
	public Integer getPosiljaocID() {
		return this.posiljaocID;
	}
	
	public Integer getPrimaocID() {
		return this.primaocID;
	}
	
	public Integer getPanelID() {
		return this.panelID;
	}
	
	//Setters
	/*
	public void setId(Integer id) {
		this.id = id;
	}
	 */
	public void setPosiljaocID(Integer id) {
		this.posiljaocID = id;
	}
	
	public void setPrimaocID(Integer id) {
		this.primaocID = id;
	}
	
	public void setPanelID(Integer id) {
		this.panelID = id;
	}
	
	//Methods
	@Override
	public String toString() {
		return String.format("{ \"pozivnica_id\": %d, \"korisnik_poslao_id\": %d, \"korisnik_prima_id\": %d, "
				+ "\"panel_id\": %d }", this.id, this.posiljaocID, this.primaocID, this.panelID);
	}
	
}
