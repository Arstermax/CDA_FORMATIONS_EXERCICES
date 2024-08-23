package org.example.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.dto.BookDto;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.service.BookService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService<Book, BookDto> {


    @Inject
    BookRepository bookRepository;

    @Override
    public Book dtoToEntity(BookDto dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        return book;
    }

    @Override
    public BookDto entityToDto(Book entity) {
        return new BookDto(entity.getId(), entity.getTitle(), entity.getAuthor(), entity.getPrice());
    }

    @Override
    public Book oldEntityToNewEntity(Book oldEntity, Book newEntity) {
        oldEntity.setAuthor(newEntity.getAuthor());
        oldEntity.setPrice(newEntity.getPrice());
        oldEntity.setTitle(newEntity.getTitle());
        return oldEntity;
    }

    @Override
    public BookDto save(BookDto entity) {
        bookRepository.persist(dtoToEntity(entity));
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public BookDto saveEntity(Book entity) {
        bookRepository.persist(entity);
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public BookDto update(long id, BookDto entity) {
        Book oldBook = dtoToEntity(findByID(id));
        if (oldBook == null)
            return null;
        Book book = oldEntityToNewEntity(oldBook, dtoToEntity(entity));
        return save(entityToDto(book));
    }

    @Override
    public boolean delete(long id) {
        if (findByID(id) == null)
            return false;
        return bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> findAll() {
        PanacheQuery<Book> books = bookRepository.findAll();
        List<BookDto> booksDto = new ArrayList<>();
        for (Book book : books.list()) {
            booksDto.add(entityToDto(book));
        }
        return booksDto;
    }

    @Override
    public BookDto findByID(long id) {
        return entityToDto(bookRepository.findById(id));
    }
}
