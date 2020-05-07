package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Book> getBooks(Model model){


        model.addAttribute("books", bookRepository.findAll());

        return bookRepository.findAll();
    }
}
