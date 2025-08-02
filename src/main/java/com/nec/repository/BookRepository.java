package com.nec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nec.entiry.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
