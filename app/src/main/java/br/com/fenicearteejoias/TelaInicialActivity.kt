package br.com.fenicearteejoias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

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
    }
}