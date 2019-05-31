package br.senai.rn.agenda.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.senai.rn.agenda.model.Aluno;

@Dao
public interface RoomAlunoDAO {
    @Insert
    void salva(Aluno aluno);

    @Update
    void edita(Aluno aluno);

    @Delete
    void remove(Aluno aluno);

    @Query("SELECT * FROM alunos")
    List<Aluno> todos();
}
