package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Inside the run method............................!");

        Publisher p1 = new Publisher();

        Author eric = new Author("Eric", "Evans");
        Book b1 = new Book("b1", "abcd");

        b1.getAuthors().add(eric);
        eric.getBooks().add(b1);

        authorRepository.save(eric);
        bookRepository.save(b1);

        Author baki = new Author("Baki", "Hanama");
        Book b2 = new Book("b2", "efgh");


        p1.setName("Penguin");
        p1.setpAddress("New Delhi, India");

        publisherRepository.save(p1);

        b2.getAuthors().add(baki);
        eric.getBooks().add(b2);
        b2.setPublisher(p1);
        p1.getBooks().add(b2);


        authorRepository.save(baki);
        bookRepository.save(b2);

        System.out.println("BootStrap Started.......!");
        System.out.println("Book Count is "+bookRepository.count());
        System.out.println("Publisher count is "+p1.getBooks().size());
    }

    
    
}
