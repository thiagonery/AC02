package br.com.fenicearteejoias

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.*

class ProdutosAdapter(
        val produtos: List<Produtos>,
        val onClick: (Produtos) -> Unit
) : RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>(){
    class ProdutosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_produtos)
        }
    }

    override fun getItemCount() = this.produtos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)

        val holder = ProdutosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produtos = this.produtos[position]

        holder.cardNome.text = produtos.nome
        holder.cardProgress.visibility = View.VISIBLE

        val contexto = holder.itemView.context

        with(contexto).load(produtos.foto).fit().into(holder.cardImg,
        object: com.squareup.picasso.Callback {
            override fun onSuccess() {
                holder.cardProgress.visibility = View.GONE
            }

            override fun onError() {
                holder.cardImg.setImageResource(R.drawable.fenicelogo)//Exibe o logo caso não exiba as imagens da internet
            }
        }
            )

        holder.itemView.setOnClickListener { onClick(produtos)}

    }

}