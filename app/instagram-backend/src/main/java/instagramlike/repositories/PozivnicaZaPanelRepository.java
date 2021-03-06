package instagramlike.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import instagramlike.models.PozivnicaZaPanel;

@Repository
public interface PozivnicaZaPanelRepository extends CrudRepository<PozivnicaZaPanel, Integer> {
	
	public List<PozivnicaZaPanel> findAll();
	public PozivnicaZaPanel findById(Integer ID);
	public PozivnicaZaPanel findBypanelID(Integer ID);
	public List<PozivnicaZaPanel> findByposiljaocID(Integer ID);
	public List<PozivnicaZaPanel> findByprimaocID(Integer ID);
	public Integer deleteById(Integer ID);
	public Integer deleteByposiljaocID(Integer ID);
	public Integer deleteByprimaocID(Integer ID);
	public Integer deleteByPanelID(Integer ID);

}
