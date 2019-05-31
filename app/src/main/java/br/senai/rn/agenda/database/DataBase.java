package br.senai.rn.agenda.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import br.senai.rn.agenda.database.conversor.CalendarConversor;
import br.senai.rn.agenda.database.dao.RoomAlunoDAO;
import br.senai.rn.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 3, exportSchema = false)
@TypeConverters({CalendarConversor.class})
public abstract class DataBase extends RoomDatabase {

    private static String NOME_BANCO_DADOS = "agenda.db";

    private static DataBase dataBase;

    public abstract RoomAlunoDAO getRoomAlunoDAO();


    public static DataBase getInstance(Context context){

        if (dataBase == null){
            dataBase = Room.databaseBuilder(context, DataBase.class, NOME_BANCO_DADOS)
                    .allowMainThreadQueries()
                    .addMigrations(new Migration(1, 2) {
                                       @Override
                                       public void migrate(@NonNull SupportSQLiteDatabase database) {
                                           String sql = "ALTER TABLE alunos ADD COLUMN sobrenome TEXT";
                                           database.execSQL(sql);
                                       }
                                   },
                            new Migration(2, 3) {
                                @Override
                                public void migrate(@NonNull SupportSQLiteDatabase database) {
                                    String sql = "ALTER TABLE alunos ADD COLUMN dataCriacao INTEGER";
                                    database.execSQL(sql);
                                }
                            }
                    )
                    .build();
            return dataBase;
        }
        return dataBase;
    }
}
