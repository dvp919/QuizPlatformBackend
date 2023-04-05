package com.humber.j2ee.controller;

import com.humber.j2ee.model.exam.Category;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.humber.j2ee.model.exam.Quiz;
import com.humber.j2ee.service.QuizService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//Add Quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}

	
	
	//Update Quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> quizzes()
	{
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	
	//Get Quiz
	@GetMapping("/{qid}")
	public Quiz quiz(@PathVariable("qid") Long qid)
	{
		return this.quizService.getQuiz(qid);
	}
	
	
	//Delete Quiz
	@DeleteMapping("/{qid}")
	public void deleteQuiz(@PathVariable("qid") Long qid)
	{
		this.quizService.deleteQuiz(qid);
	}
	
	
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") long cid)
	{
		Category category= new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}

	//Get only active quizzes
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes()
	{
		return this.quizService.getActiveQuizzes();
	}

	//Get only active quizzes of category
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid)
	{
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}
}
