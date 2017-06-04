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
	public Boolean deleteByposiljaocID(Integer ID);
	public Boolean deleteByprimaocID(Integer ID);
	public Boolean deleteByid(Integer ID);
}
