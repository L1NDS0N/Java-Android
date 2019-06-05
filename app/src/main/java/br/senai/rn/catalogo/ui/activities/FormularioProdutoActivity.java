package br.senai.rn.catalogo.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.senai.rn.catalogo.dao.ProdutoDAO;
import br.senai.rn.catalogo.models.Produto;
import br.senai.rn.catalogo.R;

public class FormularioProdutoActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_EDITA_PRODUTO = "Editar produto";
    private static final String TITULO_APPBAR_NOVO_PRODUTO = "Inserir produto";
    private EditText campoNome;
    private EditText campoPreco;
    private EditText campoFabricante;
    private Produto produto;
    private ProdutoDAO dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inicializarCampos();
    }

    public void inicializarCampos(){
        campoNome = findViewById(R.id.activity_formulario_produto_nome);
        campoPreco = findViewById(R.id.activity_formulario_produto_preco);
        campoFabricante = findViewById(R.id.activity_formulario_produto_fabricante);
    }

    private void preencherForm(){
        campoNome.setText(produto.getNome());
        campoPreco.setText(produto.getPreco());
        campoFabricante.setText(produto.getFabricante());
    }

    private void preencheProduto() {
        String nome = campoNome.getText().toString();
        String preco = campoPreco.getText().toString();
        String fabricante = campoFabricante.getText().toString();

        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setFabricante(fabricante);
    }

    private void finalizaFormulario() {
        preencheProduto();
        if (produto.temIdValido()) {
            dao.edita(produto);
        } else {
            dao.salva(produto);
        }
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.activity_formulario_produto_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
//        if(itemId == R.id.activity_formulario_produto_menu_salvar){
//            finalizaFormulario();
//        }
        return super.onOptionsItemSelected(item);
    }

    private void carregaProduto() {
        Intent dados = getIntent();
        if (dados.hasExtra(Constantes.CHAVE_PRODUTO)) {
            setTitle(TITULO_APPBAR_EDITA_PRODUTO);
            produto = (Produto) dados.getSerializableExtra(Constantes.CHAVE_PRODUTO);
            preencherForm();
        } else {
            setTitle(TITULO_APPBAR_NOVO_PRODUTO);
            produto = new Produto();
        }
    }
    
}
