package com.pykaicode.cruddemo.dao;

import java.util.List;

import com.pykaicode.cruddemo.entity.Student;

public interface StudentDAO {
  void save(Student student);

  Student findById(Integer id);

  List<Student> findAll();
}
