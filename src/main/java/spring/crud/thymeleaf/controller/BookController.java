package spring.crud.thymeleaf.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.crud.thymeleaf.entity.Book;
import spring.crud.thymeleaf.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String findAllBooks(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "all-books";
    }

    @GetMapping("/add")
    public String launchAddBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/addbook")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/ ";
    }

    @GetMapping("/edit/{id}")
    public String launchEditBookPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookService.findBookById(id));
        return "edit-book";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

    @PostMapping("/updatebook")
    public String updateBook(Book book){
        bookService.updateBook(book);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String test() {
        Book book = new Book(
                "ABCD", "Aman", 10, "2019"
        );
        bookService.addBook(book);
        return book.getAuthor();
    }

}
