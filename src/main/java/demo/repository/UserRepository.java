package demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import demo.model.Usertable;

@Repository
public interface UserRepository extends CrudRepository<Usertable, String>{

	
	
}
