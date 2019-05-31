package br.senai.rn.agenda.database.conversor;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;

public class CalendarConversor {
    @TypeConverter
    public Long paraLong(Calendar valor){
        return valor.getTimeInMillis();
    }


    @TypeConverter
    public Calendar paraCalendar(Long valor){
        if (valor != null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(valor);
            return calendar;
        }
        return null;
    }
}
