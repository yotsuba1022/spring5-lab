package idv.carl.spring5lab.bootstrap;

import idv.carl.spring5lab.model.Author;
import idv.carl.spring5lab.model.Book;
import idv.carl.spring5lab.model.Publisher;
import idv.carl.spring5lab.repositories.AuthorRepository;
import idv.carl.spring5lab.repositories.BookRepository;
import idv.carl.spring5lab.repositories.PublisherRepository;
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
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher prenticeHall = new Publisher("Prentice Hall", "Address of Prentice Hall");
        Author robert = new Author("Robert C.", "Martin");
        Book cCode = new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "0132350882", prenticeHall);
        robert.getBooks().add(cCode);
        cCode.getAuthors().add(robert);

        publisherRepository.save(prenticeHall);
        authorRepository.save(robert);
        bookRepository.save(cCode);

        Publisher addisonWesley = new Publisher("Addison-Wesley Professional", "Address of Addison-Wesley");
        Author joshua = new Author("Joshua", "Bloch");
        Book eJava = new Book("Effective Java (3rd Edition)", "0134685997", addisonWesley);
        joshua.getBooks().add(eJava);
        eJava.getAuthors().add(joshua);

        publisherRepository.save(addisonWesley);
        authorRepository.save(joshua);
        bookRepository.save(eJava);
    }

}
