package com.dojo.startermvc.services;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.startermvc.models.Book;
import com.dojo.startermvc.repositories.BookRepository;

@Service  //logique métier de notre application
public class BookService {
	 // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // update a book
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book bookToUpdate = findBook(id);
    	bookToUpdate.setTitle(title);   // getter & setter
    	bookToUpdate.setDescription(desc);
    	bookToUpdate.setLanguage(lang);
    	bookToUpdate.setNumberOfPages(numOfPages);
        return bookRepository.save(bookToUpdate);
    }
    
    // delete book
    
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
        return;
    }
    
 
    // return ts ls livres contenant l terme d la recherch
    public List<Book> booksContaining(String search){
    	return bookRepository.findByDescriptionContaining(search);    }
}
