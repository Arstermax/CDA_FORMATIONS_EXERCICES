package org.example.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.dto.AuthorDto;
import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.example.service.AuthorService;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService<Author, AuthorDto> {


    @Inject
    AuthorRepository authorRepository;

    @Override
    public Author dtoToEntity(AuthorDto dto) {
        Author author = new Author();
        author.setId(dto.getId());
        author.setName(dto.getName());
        return author;
    }

    @Override
    public AuthorDto entityToDto(Author entity) {
        return new AuthorDto(entity.getId(), entity.getName());
    }

    @Override
    public Author oldEntityToNewEntity(Author oldEntity, Author newEntity) {
        oldEntity.setId(newEntity.getId());
        oldEntity.setName(newEntity.getName());
        return oldEntity;
    }

    @Override
    public AuthorDto save(AuthorDto entity) {
        authorRepository.persist(dtoToEntity(entity));
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public AuthorDto saveEntity(Author entity) {
        authorRepository.persist(entity);
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public AuthorDto update(long id, AuthorDto entity) {
        Author oldAuthor = dtoToEntity(findByID(id));
        if (oldAuthor == null)
            return null;
        Author book = oldEntityToNewEntity(oldAuthor, dtoToEntity(entity));
        return save(entityToDto(book));
    }

    @Override
    public boolean delete(long id) {
        if (findByID(id) == null)
            return false;
        return authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDto> findAll() {
        PanacheQuery<Author> author = authorRepository.findAll();
        List<AuthorDto> authorDto = new ArrayList<>();
        for (Author book : author.list()) {
            authorDto.add(entityToDto(book));
        }
        return authorDto;
    }

    @Override
    public AuthorDto findByID(long id) {
        return entityToDto(authorRepository.findById(id));
    }
}
