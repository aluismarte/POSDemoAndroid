package com.alsjava.courses.posdemoandroid.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.alsjava.courses.posdemoandroid.model.EnumDemo
import com.alsjava.courses.posdemoandroid.utils.db.converters.EnumDemoConverter

/**
 * Created by aluis on 11/16/19.
 */
@Entity(tableName = "professors")
class Professor {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    @TypeConverters(EnumDemoConverter::class)
    var enumDemo: EnumDemo? = null

}
