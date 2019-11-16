package com.alsjava.courses.posdemoandroid.repository;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.alsjava.courses.posdemoandroid.domain.Student;

import java.util.List;

/**
 * Created by aluis on 11/16/19.
 */
@Dao
public interface StudentRepository {

    @Query("SELECT * FROM students WHERE id = :id")
    Student findByID(long id);

    @Query("SELECT * from students")
    List<Student> findAll();

    @Insert
    void save(Student student);

    @Update
    void update(Student student);
}
