package people.api.people.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import people.api.people.model.Book;
import people.api.people.repository.BookRepository;
import people.api.people.web.dto.CreateBookRequest;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @PostMapping(value = "/books")
    private Book createBook(@RequestBody CreateBookRequest createBookRequest){
        Book book = Book.builder().author(createBookRequest.getAuthor()).name(createBookRequest.getName()).build();
        return bookRepository.save(book);
    }

    
}
