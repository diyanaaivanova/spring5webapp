package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St. Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);


        //Checking Results+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        System.out.println("Publisher Count: " + publisherRepository.count());


        // Example1 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //Author
        Author eric = new Author("Eric", "Evans");
        //Book
        Book ddd = new Book("Domain Driven Design", "123123");

        //Dependencies
        //eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        //Saving into Repository
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        //Example2 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        //Author
        Author rod = new Author("Rod", "Johanson");
        //Book
        Book noEJB = new Book("J2EE Development without EJB", "35354562626");

        
        //rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        //Saving into Repository
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        //Checking Results+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());






    }
}
