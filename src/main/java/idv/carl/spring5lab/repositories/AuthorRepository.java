package idv.carl.spring5lab.repositories;

import idv.carl.spring5lab.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carl Lu
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
