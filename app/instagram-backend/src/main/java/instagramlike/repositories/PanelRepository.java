package instagramlike.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import instagramlike.models.Panel;



@Repository
public interface PanelRepository extends CrudRepository<Panel, Integer> {
	
	public List<Panel> findAll();
	public Panel findById(Integer ID);
	public List<Panel> findBykreatorID(Integer ID);
	public Boolean deleteById(Integer ID);
	public Boolean deleteBykreatorID(Integer ID);

}
