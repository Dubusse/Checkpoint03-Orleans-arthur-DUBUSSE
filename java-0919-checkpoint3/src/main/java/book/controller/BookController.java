package book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import book.repository.BookRepository;

public class BookController {
	  @Autowired
	    private BookRepository bookRepository;
	  
	  @GetMapping("/book")
	    public String getSchools(Model out) {

	        out.addAttribute("book", bookRepository.findAll());

	        return "book";
	    }
}
