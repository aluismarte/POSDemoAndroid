package com.alsjava.courses.posdemoandroid.utils.db.converters;

import androidx.room.TypeConverter;

import com.alsjava.courses.posdemoandroid.model.EnumDemo;

/**
 * Created by aluis on 11/16/19.
 */
public class EnumDemoConverter {

    @TypeConverter
    public Integer from(EnumDemo enumDemo) {
        if (enumDemo == null) {
            return (null);
        }
        switch (enumDemo) {
            case HOLA:
                return 1;
            case MUNDO:
                return 2;
        }
        return null;
    }

    @TypeConverter
    public EnumDemo to(Integer data) {
        if (data == null) {
            return null;
        }
        switch (data) {
            case 1:
                return EnumDemo.HOLA;
            case 2:
                return EnumDemo.MUNDO;
        }
        return null;
    }
}
