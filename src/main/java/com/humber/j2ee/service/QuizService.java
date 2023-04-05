package com.humber.j2ee.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.humber.j2ee.model.exam.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.humber.j2ee.model.exam.Quiz;
import com.humber.j2ee.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	public Quiz addQuiz(Quiz quiz)
	{
		return this.quizRepository.save(quiz);
	}
	
	public Quiz updateQuiz(Quiz quiz)
	{
		return this.quizRepository.save(quiz);
	}
	
	public Set<Quiz> getQuizzes()
	{
		return new HashSet<>(this.quizRepository.findAll());
	}
	
	public Quiz getQuiz(Long quizId)
	{
		return this.quizRepository.findById(quizId).get();
	}
	
//	public Quiz getQuiz(Long quizId) {
//	    return this.quizRepository.findById(quizId)
//	            .orElseThrow(() -> new IllegalArgumentException("Quiz not found with id: " + quizId));
//	}
	
	public void deleteQuiz(Long quizId)
	{
		this.quizRepository.deleteById(quizId);
	}


	public List<Quiz> getQuizzesOfCategory(Category category) {
		return this.quizRepository.findBycategory(category);
	}

	//get active quiz
	public List<Quiz> getActiveQuizzes()
	{
		return this.quizRepository.findByActive(true);
	}

	public List<Quiz> getActiveQuizzesOfCategory(Category c)
	{
		return this.quizRepository.findByCategoryAndActive(c,true);
	}

}
