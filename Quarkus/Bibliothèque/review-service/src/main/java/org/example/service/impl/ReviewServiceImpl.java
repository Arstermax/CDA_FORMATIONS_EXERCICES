package org.example.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.dto.ReviewDto;
import org.example.entity.Review;
import org.example.repository.ReviewRepository;
import org.example.service.ReviewService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ReviewServiceImpl implements ReviewService<Review, ReviewDto> {


    @Inject
    ReviewRepository reviewRepository;

    @Override
    public Review dtoToEntity(ReviewDto dto) {
        Review review = new Review();
        review.setId(dto.getId());
        return review;
    }

    @Override
    public ReviewDto entityToDto(Review entity) {
        return new ReviewDto(entity.getId(), entity.getLibelle(), entity.getDate());
    }

    @Override
    public Review oldEntityToNewEntity(Review oldEntity, Review newEntity) {
        oldEntity.setId(newEntity.getId());
        oldEntity.setLibelle(newEntity.getLibelle());
        oldEntity.setDate(newEntity.getDate());
        return oldEntity;
    }

    @Override
    public ReviewDto save(ReviewDto entity) {
        reviewRepository.persist(dtoToEntity(entity));
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public ReviewDto saveEntity(Review entity) {
        reviewRepository.persist(entity);
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public ReviewDto update(long id, ReviewDto entity) {
        Review oldReviex = dtoToEntity(findByID(id));
        if (oldReviex == null)
            return null;
        Review review = oldEntityToNewEntity(oldReviex, dtoToEntity(entity));
        return save(entityToDto(review));
    }

    @Override
    public boolean delete(long id) {
        if (findByID(id) == null)
            return false;
        return reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDto> findAll() {
        PanacheQuery<Review> reviews = reviewRepository.findAll();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (Review book : reviews.list()) {
            reviewDtos.add(entityToDto(book));
        }
        return reviewDtos;
    }

    @Override
    public ReviewDto findByID(long id) {
        return entityToDto(reviewRepository.findById(id));
    }
}
