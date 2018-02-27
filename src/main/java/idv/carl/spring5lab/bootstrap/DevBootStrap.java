package idv.carl.spring5lab.bootstrap;

import idv.carl.spring5lab.model.Author;
import idv.carl.spring5lab.model.Book;
import idv.carl.spring5lab.repositories.AuthorRepository;
import idv.carl.spring5lab.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Carl Lu
 */
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author robert = new Author("Robert C.", "Martin");
        Book cCode = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "0132350882", "Prentice Hall");
        robert.getBooks().add(cCode);
        cCode.getAuthors().add(robert);

        authorRepository.save(robert);
        bookRepository.save(cCode);

        Author joshua = new Author("Joshua", "Bloch");
        Book eJava = new Book("Effective Java (3rd Edition)", "0134685997", "Addison-Wesley Professional");
        joshua.getBooks().add(eJava);
        eJava.getAuthors().add(joshua);

        authorRepository.save(joshua);
        bookRepository.save(eJava);
    }

}
