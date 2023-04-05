package com.humber.j2ee.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humber.j2ee.model.exam.Question;
import com.humber.j2ee.model.exam.Quiz;
import com.humber.j2ee.repository.QuestionRepository;
import com.humber.j2ee.repository.QuizRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question addQuestion(Question question)
	{
		return this.questionRepository.save(question);
	}
	
	public Question updateQuestion(Question question)
	{
		return this.questionRepository.save(question);
	}
	
	public Set<Question> getQuestions()
	{
		return new HashSet<>(this.questionRepository.findAll());
	}
	
	public Question getQuestion(Long questionId)
	{
		return this.questionRepository.findById(questionId).get();
	}
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz)
	{
		return this.questionRepository.findByQuiz(quiz);
	}
	
	public void deleteQuestion(Long quesId)
	{
		Question question = new Question();
		question.setQuesId(quesId);
		this.questionRepository.delete(question);
		
	}
	
}
