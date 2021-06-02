package br.com.fenicearteejoias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val nome_usuario = Prefs.getString("nome_usuario")
        Toast.makeText(this, "Prefs: ${nome_usuario}", Toast.LENGTH_SHORT).show()

        val args = intent.extras
        val usuario = args?.getString("usuario")
        var numero = args?.getInt("numero")
        var logico_2 = args?.getBoolean("logico_2")

        Toast.makeText(this, usuario, Toast.LENGTH_LONG).show()
//        textoTelaInicial.setText("Olá, $usuario")

        //setSupportActionBar(toolbar)
        //supportActionBar?.title = "Home"
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        //Configurações do RecyclerView
        recyclerProdutos?.layoutManager = LinearLayoutManager(this)
        recyclerProdutos?.itemAnimator = DefaultItemAnimator()
        recyclerProdutos?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskProdutos()
    }

    private var produtos = listOf<Produtos>()

    private fun taskProdutos() {

        Thread {
            this.produtos = ProdutosService.getProdutos()
            runOnUiThread {
                //Atualizar lista
                recyclerProdutos?.adapter =
                        ProdutosAdapter(produtos) {onClickProduto(it)}
            }
        }.start()
    }
    //Metodo para quando clicar no cartão
    fun onClickProduto(produtos: Produtos) {
        Toast.makeText(this, "Clicou no produto ${produtos.nome}", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, DetalheProduto::class.java)
        intent.putExtra("Produto", produtos)
        startActivity(intent)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId

        when (id) {
            R.id.action_buscar -> {
                Toast.makeText(this, "Clicou em Buscar", Toast.LENGTH_SHORT).show()
            }
            R.id.action_atualizar -> {
                Toast.makeText(this, "Clicou em Atualizar", Toast.LENGTH_SHORT).show()
            }
            R.id.action_config -> {
                var intent = Intent(this, ConfigActivity::class.java)
                Toast.makeText(this, "Clicou em Configurações", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            android.R.id.home -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}