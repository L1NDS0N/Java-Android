package br.senai.rn.catalogo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.provider.ContactsContract;

import br.senai.rn.catalogo.database.dao.RoomProdutoDAO;
import br.senai.rn.catalogo.models.Produto;

@Database(entities = {Produto.class}, version = 1, exportSchema = false)
public abstract class ProdutoDatabase extends RoomDatabase {



public abstract class DataBase extends RoomDatabase {

    private static String NOME_BANCO_DADOS = "catalogo.db";
    private static ProdutoDatabase dataBase;


    public abstract RoomProdutoDAO getRoomProdutoDAO();


    public static ProdutoDatabase getInstance(Context context){

        if (dataBase == null){
            dataBase = Room.databaseBuilder(context, ProdutoDatabase.class, NOME_BANCO_DADOS)
                    .allowMainThreadQueries()
                    .build();
            return dataBase;
        }
        return dataBase;
    }
}