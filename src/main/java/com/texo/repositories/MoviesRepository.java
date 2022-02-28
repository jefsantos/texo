package com.texo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texo.model.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer>{

}
