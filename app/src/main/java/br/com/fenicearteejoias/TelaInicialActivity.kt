package br.com.fenicearteejoias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val usuario = args?.getString("usuario")
        /*var numero = args?.getInt("numero")
        var logico_2 = args?.getBoolean("logico_2")*/

        Toast.makeText(this, usuario, Toast.LENGTH_LONG).show()
        textoTelaInicial.setText("Olá, $usuario")

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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