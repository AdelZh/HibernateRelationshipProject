package org.example.config;


import org.example.model.*;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.PublisherService;
import org.example.service.ReaderService;
import org.example.service.impl.AuthorServiceImpl;
import org.example.service.impl.BookServiceImpl;
import org.example.service.impl.PublisherServiceImpl;
import org.example.service.impl.ReaderServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args ) {

        SessionFactory sessionFactory = Config.getSession();


        try (Session session=sessionFactory.openSession()) {
            session.beginTransaction();

            LocalDate authorBirthdate = LocalDate.of(2000, 2, 6);
            PublisherService publisherService = new PublisherServiceImpl();
            AuthorService authorService = new AuthorServiceImpl();
            BookService bookService = new BookServiceImpl();
            ReaderService readerService = new ReaderServiceImpl();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Save publisher, author, book, reader");
                System.out.println("2. Get author by id");
                System.out.println("3. Get author by publisher id");
                System.out.println("4. Update author");
                System.out.println("5. Update books author");
                System.out.println("6. Get books and publisher by book id");
                System.out.println("7. Get publisher by id");
                System.out.println("8. Get all publisher by asc or desc");
                System.out.println("9. Update publisher");
                System.out.println("10. Get reader by book id");
                System.out.println("11. Get readers by author id");
                System.out.println("12. Update reader");
                System.out.println("13. Delete author by id");
                System.out.println("14. Delete publisher by id");
                System.out.println("15. Delete book by author id");
                System.out.println("16. Delete reader by id");
                System.out.println("17. Set new reader to book");
                System.out.println("17. Exiting...");
                System.out.println();
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Author author = new Author("Adel", "Sam", "adel@", authorBirthdate, "Korea", Gender.FEMALE);
                        Author author11 = new Author("Adel", "Sam", "adel@", authorBirthdate, "Korea", Gender.FEMALE);
                        Publisher publisher = new Publisher("Amazon", "Dubai");
                        Publisher publisher11 = new Publisher("Amazon", "Dubai");
                        Reader reader = new Reader("Michelle", 20, "adel@gmail.com");
                        Reader reader11 = new Reader("Michelle", 20, "adel@gmail.com");


                        List<Author> authors = new ArrayList<>();
                        authors.add(author);
                        authors.add(author11);

                        List<Publisher> publishers = new ArrayList<>();
                        publishers.add(publisher);
                        publishers.add(publisher11);


                        author.setPublishers(publishers);
                        author11.setPublishers(publishers);
                        publisher.setAuthors(authors);
                        publisher11.setAuthors(authors);


                        Book book1 = new Book("Becoming", "Korea", authorBirthdate, 200, Genre.ROMANCE);
                        Book book2 = new Book("Interstellar", "China", authorBirthdate, 200, Genre.SCIENTIFIC);

                        Book book11 = new Book("Becoming", "Korea", authorBirthdate, 200, Genre.ROMANCE);
                        Book book22 = new Book("Interstellar", "China", authorBirthdate, 200, Genre.SCIENTIFIC);

                        author.setBooks(List.of(book1, book2));
                        author11.setBooks(List.of(book11, book22));
                        book1.setAuthors(author);
                        book2.setAuthors(author);
                        book11.setAuthors(author11);
                        book22.setAuthors(author11);

                        publisher.setBooks(List.of(book1, book2));
                        publisher11.setBooks(List.of(book11, book22));
                        book1.setPublishers(publisher);
                        book2.setPublishers(publisher);
                        book11.setPublishers(publisher11);
                        book22.setPublishers(publisher11);


                        reader.setBooks(List.of(book1, book2));
                        reader11.setBooks(List.of(book11, book22));
                        book1.setReaders(reader);
                        book2.setReaders(reader);
                        book11.setReaders(reader11);
                        book22.setReaders(reader11);
                        System.out.println(publisherService.savePublisher(publishers));
                        break;
                    case 2:
                        System.out.println(authorService.getAuthorById(2L));
                        break;
                    case 3:
                        System.out.println(authorService.getAuthorsByPublisherId(2L));
                        break;
                    case 4:
                        Author author0 = new Author();
                        author0.setLast_name("new_name");
                        author0.setCountry("new_country");
                        System.out.println(authorService.updateAuthor(2L, author0));
                        break;
                    case 5:
                        Author author2 = new Author();
                        author2.setFirst_name("last_name");
                        author2.setLast_name("first_name");
                        System.out.println(bookService.updateBookAuthor(3L, 2L, author2));
                        break;
                    case 6:
                        System.out.println(bookService.getBookAndPublisherByBookId(3L));
                        break;
                    case 7:
                        System.out.println(publisherService.getPublisherById(2L));
                        break;
                    case 8:
                        System.out.println(publisherService.getAllPublishers("asc"));
                        break;
                    case 9:
                        Publisher publisher1 = new Publisher();
                        publisher1.setName("new_name");
                        publisher1.setAddress("new_address");
                        System.out.println(publisherService.updatePublisher(1L, publisher1));
                        break;
                    case 10:
                        System.out.println(readerService.getReaderByBookId(1L));
                        break;
                    case 11:
                        System.out.println(readerService.getReadersByAuthorId(1L));
                        break;
                    case 12:
                        Reader reader1 = new Reader();
                        reader1.setName("new_reader");
                        System.out.println(readerService.updateReader(1L, reader1));
                        break;
                    case 13:
                        System.out.println(authorService.deleteAuthorById(1L));
                        break;
                    case 14:
                        System.out.println(publisherService.deletePublisherByName(2L));
                        break;
                    case 15:
                        System.out.println(bookService.deleteBookByAuthorId(2L, 3L));
                        break;
                    case 16:
                        System.out.println(readerService.deleteReaderById(1L));
                        break;
                    case 17:
                        bookService.updateBookTable(1L, new Reader("Kandy", 20, "kandy@gmail.com"));
                        break;
                    case 18:
                        session.getTransaction().commit();
                        session.close();
                        System.exit(0);

                }
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

