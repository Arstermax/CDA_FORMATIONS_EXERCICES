package org.example.bibliotheque.service;

import org.example.bibliotheque.model.Livre;
import org.example.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private LivreRepository livreRepository;

    public Livre createBook(Livre livre) {
        return livreRepository.save(livre);
    }

    public List<Livre> findAllBook() {
        return livreRepository.findAll();
    }

    public boolean deleteBook(Long id) {
        livreRepository.delete(livreRepository.getReferenceById(id));
        return livreRepository.existsById(id);
    }
}
