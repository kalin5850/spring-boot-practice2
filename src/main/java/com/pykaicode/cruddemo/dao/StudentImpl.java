package com.pykaicode.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pykaicode.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentImpl implements StudentDAO {

  private EntityManager entityManager;

  @Autowired
  public StudentImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Student student) {
    this.entityManager.persist(student);
  }

  @Override
  public Student findById(Integer id) {
    return this.entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);

    return query.getResultList();
  }

}
