package instagramlike.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import instagramlike.models.ZahtjevZaPrijateljstvo;
@Repository
public interface ZahtjevZaPrijateljstvoRepository  extends CrudRepository<ZahtjevZaPrijateljstvo, Integer> {
	public List<ZahtjevZaPrijateljstvo> findAll();
	public List<ZahtjevZaPrijateljstvo> findAllByposiljaocID(Integer ID);
	public List<ZahtjevZaPrijateljstvo> findAllByprimaocID(Integer ID);
	public ZahtjevZaPrijateljstvo findByid(Integer ID);
	public Integer deleteByposiljaocID(Integer ID);
	public Integer deleteByprimaocID(Integer ID);
	public Integer deleteByid(Integer ID);
}
