package com.pykaicode.cruddemo.dao;

import com.pykaicode.cruddemo.entity.Student;

public interface StudentDAO {
  void save(Student student);

  Student findById(Integer id);
}
