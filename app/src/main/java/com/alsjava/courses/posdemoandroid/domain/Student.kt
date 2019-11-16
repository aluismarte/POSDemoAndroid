package com.alsjava.courses.posdemoandroid.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by aluis on 11/16/19.
 */
@Entity(tableName = "students")
class Student {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null


}
