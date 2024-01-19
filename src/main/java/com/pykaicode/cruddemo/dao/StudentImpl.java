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
    TypedQuery<Student> query = this.entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);

    return query.getResultList();
  }

  @Override
  public List<Student> findByLastName(String lastName) {
    TypedQuery<Student> query = this.entityManager.createQuery("FROM Student WHERE lastName = :lastName",
        Student.class);
    query.setParameter("lastName", lastName);

    return query.getResultList();
  }

  @Override
  @Transactional
  public void update(Student student) {
    this.entityManager.merge(student);
  }

}
