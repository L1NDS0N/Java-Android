package br.senai.rn.catalogo.dao;


import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.senai.rn.catalogo.models.Produto;

public class ProdutoDAO {

    private final static List<Produto> produtos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva (Produto produto) {
        produto.setId(contadorDeIds);
        produtos.add(produto);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Produto produto) {
        Produto produtoEncontrado = buscaProdutoPeloId(produto);
        if (produtoEncontrado != null) {
            int posicaoDoProduto = produtos.indexOf(produtoEncontrado);
            produtos.set(posicaoDoProduto, produto);
        }
    }

    @Nullable
    private Produto buscaProdutoPeloId(Produto produto) {
        for (Produto a :
                produtos) {
            if (a.getId() == produto.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Produto> todos() {
        return new ArrayList<>(produtos);
    }

    public void remove(Produto produto) {
        Produto produtoDevolvido = buscaProdutoPeloId(produto);
        if(produtoDevolvido != null){
            produtos.remove(produtoDevolvido);
        }
    }
}