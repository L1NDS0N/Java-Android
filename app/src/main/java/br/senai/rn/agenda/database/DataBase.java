package br.senai.rn.agenda.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.provider.ContactsContract;

import br.senai.rn.agenda.database.dao.RoomAlunoDAO;
import br.senai.rn.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {

    private static String NOME_BANCO_DADOS = "agenda.db";

    private static DataBase dataBase;

    public abstract RoomAlunoDAO getRoomAlunoDAO();


    public static DataBase getInstance(Context context){

        if (dataBase == null){
            dataBase = Room.databaseBuilder(context, DataBase.class, NOME_BANCO_DADOS)
                    .allowMainThreadQueries()
                    .build();
            return dataBase;
        }
        return dataBase;
    }
}
