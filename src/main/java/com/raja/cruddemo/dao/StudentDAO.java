package com.raja.cruddemo.dao;

import com.raja.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    //Create
    void save(Student theStudent);

    //Read
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    //Update
    void update(Student theStudent);

    //Delete
    void delete(Integer id);

    //Delete all
    int deleteall();


}
