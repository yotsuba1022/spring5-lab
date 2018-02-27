package idv.carl.spring5lab.repositories;

import idv.carl.spring5lab.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Carl Lu
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
