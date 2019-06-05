package br.senai.rn.catalogo;

import android.app.Application;
import android.view.View;

import br.senai.rn.catalogo.dao.ProdutoDAO;
import br.senai.rn.catalogo.models.Produto;

@SuppressWarnings("WeakerAccess")
public class CatalogoApplication extends Application {
    View.OnCreateContextMenuListener

    @Override
    public void onCreate() {
        super.onCreate();
        criaProdutosDeTeste();
    }

    private void criaProdutosDeTeste() {

        ProdutoDAO dao = DataBase.getInstance(this).getRoomProdutoDAO();
        dao.salva(new Produto("Alex", "1122223333", "alex@alura.com.br"));
        dao.salva(new Produto("Fran", "1122223333", "fran@gmail.com"));
    }
}