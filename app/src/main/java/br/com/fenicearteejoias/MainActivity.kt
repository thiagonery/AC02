package br.com.fenicearteejoias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.login.*
import android.widget.Toast

class MainActivity : DebugActivity  () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imageview_login.setImageResource(R.drawable.fenicelogo)

        botao_login.setOnClickListener {
            val textoUsuario = campo_usuario.text.toString()
            val textoSenha = campo_senha.text.toString()

            var intent = Intent(this, TelaInicialActivity::class.java)

            val params = Bundle()
            params.putString("usuario", textoUsuario)

            intent.putExtras(params)

            if (textoUsuario.equals("aluno") && textoSenha.equals("impacta")) {
                Toast.makeText(this, "Funcionou", Toast.LENGTH_LONG).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos, tente novamente.", Toast.LENGTH_LONG).show()
            }
        }
    }

}