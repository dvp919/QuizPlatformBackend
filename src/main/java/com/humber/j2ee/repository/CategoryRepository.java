package com.humber.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humber.j2ee.model.exam.Category;


public interface CategoryRepository extends JpaRepository<Category,Long> {

}
