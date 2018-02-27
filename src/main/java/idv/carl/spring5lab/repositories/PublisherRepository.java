package idv.carl.spring5lab.repositories;

import idv.carl.spring5lab.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carl Lu
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
