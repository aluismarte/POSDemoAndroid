package com.alsjava.courses.posdemoandroid.utils.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.alsjava.courses.posdemoandroid.domain.Professor;
import com.alsjava.courses.posdemoandroid.domain.Student;
import com.alsjava.courses.posdemoandroid.repository.ProfessorRepository;
import com.alsjava.courses.posdemoandroid.repository.StudentRepository;

/**
 * Created by aluis on 11/16/19.
 */
@Database(entities = {Student.class, Professor.class}, version = 1, exportSchema = false)
public abstract class POSDemoDB extends RoomDatabase {

    public static final String DB_NAME = "POS_DEMO_Android";

    public abstract StudentRepository studentRepository();

    public abstract ProfessorRepository professorRepository();
}
