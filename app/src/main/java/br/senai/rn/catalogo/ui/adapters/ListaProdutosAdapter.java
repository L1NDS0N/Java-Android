package br.senai.rn.catalogo.ui.adapters;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

        import br.senai.rn.catalogo.R;
        import br.senai.rn.catalogo.models.Produto;

public class ListaProdutosAdapter extends BaseAdapter {

    private final List<Produto> produtos = new ArrayList<>();
    private final Context context;

    public ListaProdutosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Produto getItem(int posicao) {
        return produtos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return produtos.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View viewCriada = criaView(viewGroup);
        Produto produtoDevolvido = produtos.get(posicao);
        vincula(viewCriada, produtoDevolvido);
        return viewCriada;
    }

    private void vincula(View view, Produto produto) {
        TextView nome = view.findViewById(R.id.item_produto_nome);
        nome.setText(produto.getNome() + " " + produto.getPreco());
        TextView telefone = view.findViewById(R.id.item_produto_fabricante);
        telefone.setText(produto.getFabricante());
    }

    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_produto, viewGroup, false);
    }

    public void atualiza(List<Produto> produtos){
        this.produtos.clear();
        this.produtos.addAll(produtos);
        notifyDataSetChanged();
    }

    public void remove(Produto produto) {
        produtos.remove(produto);
        notifyDataSetChanged();
    }
}