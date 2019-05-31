package br.senai.rn.agenda;

import android.app.Application;
import android.arch.persistence.room.Room;

import br.senai.rn.agenda.dao.AlunoDAO;
import br.senai.rn.agenda.database.DataBase;
import br.senai.rn.agenda.database.dao.RoomAlunoDAO;
import br.senai.rn.agenda.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {

        RoomAlunoDAO dao = DataBase.getInstance(this).getRoomAlunoDAO();
//        dao.salva(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
//        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}
