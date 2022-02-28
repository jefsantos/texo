package com.texo.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.texo.model.Movies;
import com.texo.repositories.MoviesRepository;
import com.texo.utils.ExcelHelper;
@Service
public class ExcelService {
  @Autowired
  MoviesRepository repository;
  public void save(MultipartFile file) {
    try {
      List<Movies> movies = ExcelHelper.excelToMovies(file.getInputStream());
      repository.saveAll(movies);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }
  public List<Movies> getAllMovies() {
    return repository.findAll();
  }
}