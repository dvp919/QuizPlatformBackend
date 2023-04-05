package com.humber.j2ee.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humber.j2ee.model.exam.Question;
import com.humber.j2ee.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question,Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
