package spring.crud.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.crud.thymeleaf.entity.Book;
import spring.crud.thymeleaf.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return (List<Book>)bookRepository.findAll();
    }

    public Book findBookById(int id) {
        Optional<Book> result = bookRepository.findById(id);
        return result.orElseGet(Book::new);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        Book bookPresent = bookRepository.findById(book.getId()).get();
        bookPresent.setAuthor(book.getAuthor());
        bookPresent.setName(book.getName());
        bookPresent.setPublication(book.getPublication());
        bookPresent.setNoOfPages(book.getNoOfPages());
        return addBook(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }



}
