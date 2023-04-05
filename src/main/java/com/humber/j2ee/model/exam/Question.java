package com.humber.j2ee.model.exam;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quesId;
	
	@Column(length = 5000)
	private String content;
	
	private String image;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	private String answer;

	@Transient
	private String givenAnswer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;


	@Override
	public int hashCode() {
		return Objects.hash(quesId, content, image, option1, option2, option3, option4,answer);
	}
}
