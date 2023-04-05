package com.humber.j2ee.repository;

import com.humber.j2ee.model.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import com.humber.j2ee.model.exam.Quiz;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

    public List<Quiz> findBycategory(Category category);

    public List<Quiz> findByActive(Boolean b);

    public List<Quiz> findByCategoryAndActive(Category c, Boolean b);

}
