package com.nec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nec.entiry.Book;
import com.nec.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository repository;
	
	public BookServiceImpl(BookRepository repository) {
		this.repository=repository;
	}
	
	public Book add(Book book) {
		return repository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		
		return repository.findById(id);
		}

	@Override
	public Book updateBook(Long id, Book updatebook) {
		return repository.findById(id).map(book->{
			book.setTitle(updatebook.getTitle());
			book.setAuthor(updatebook.getAuthor());
			book.setCategory(updatebook.getCategory());
			book.setAvailable(updatebook.isAvailable());
			return repository.save(book);
		}).orElseThrow();
		
		
//		Book book=getBookById(id);
//		book.setTitle(updatebook.getTitle());
//		book.setAuthor(updatebook.getAuthor());
//		book.setCategory(updatebook.getCategory());
//		book.setAvailable(updatebook.isAvailable());	
		
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);
		
	}
	
	
}
