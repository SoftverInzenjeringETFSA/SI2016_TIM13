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
	public Boolean deleteById(Integer ID);
	public Boolean deleteByposiljaocID(Integer ID);
	public Boolean deleteByPanelID(Integer ID);

}
