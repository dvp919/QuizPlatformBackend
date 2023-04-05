package com.humber.j2ee.model.exam;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qId;
	
	private String title;
	@Column(length = 5000)
	private String description;
	
	private String maxMarks;
	
	private String numberOfQuestions;
	
	private boolean active = false;

	
	@ManyToOne(fetch = FetchType.EAGER)
    private Category category;
	

	
	@JsonIgnore
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private Set<Question> questions = new HashSet<>();


	@Override
	public int hashCode() {
		return Objects.hash(qId, title, description, maxMarks, numberOfQuestions, active, questions);
	}

}
