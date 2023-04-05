package com.humber.j2ee.model.exam;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.humber.j2ee.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	
	private String title;
	
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Quiz> quiz = new HashSet<>();

	@Override
	public int hashCode() {
		return Objects.hash(cid, title, description, quiz);
	}
}

