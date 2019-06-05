package br.senai.rn.catalogo.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.senai.rn.catalogo.models.Produto;

@Dao
public interface RoomProdutoDAO {

    @Insert
    void salva(Produto produto);

    @Update
    void edita(Produto produto);

    @Delete
    void remove(Produto produto);

    @Query("SELECT * FROM Produto")
    List<Produto> todos();

}