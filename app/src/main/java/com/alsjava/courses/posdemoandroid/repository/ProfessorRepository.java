package com.alsjava.courses.posdemoandroid.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.alsjava.courses.posdemoandroid.domain.Professor;

/**
 * Created by aluis on 11/16/19.
 */
@Dao
public interface ProfessorRepository {

    @Insert
    void save(Professor professor);

    @Update
    void update(Professor professor);

    @Delete
    void delete(Professor professor);
}
