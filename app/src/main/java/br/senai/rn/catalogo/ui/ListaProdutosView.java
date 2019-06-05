package br.senai.rn.catalogo.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import br.senai.rn.catalogo.database.ProdutoDatabase;
import br.senai.rn.catalogo.database.dao.RoomProdutoDAO;
import br.senai.rn.catalogo.models.Produto;
import br.senai.rn.catalogo.ui.adapters.ListaProdutosAdapter;

public class ListaProdutosView {

    private final ListaProdutosAdapter adapter;
    private final RoomProdutoDAO dao;
    private final Context context;

    public ListaProdutosView(Context context) {
        this.context = context;
        this.adapter = new ListaProdutosAdapter(this.context);
        this.dao = ProdutoDatabase.getInstance(context).getRoomProdutoDAO();

    }

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo produto")
                .setMessage("Tem certeza que quer remover o produto?")
                .setPositiveButton("Sim", (dialogInterface, i) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Produto produtoEscolhido = adapter.getItem(menuInfo.position);
                    remove(produtoEscolhido);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaProdutos() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Produto produto) {
        dao.remove(produto);
        adapter.remove(produto);
    }

    public void configuraAdapter(ListView listaDeProdutos) {
        listaDeProdutos.setAdapter(adapter);
    }
}