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

        campo_usuario.setText(Prefs.getString("nome_usuario"))
        campo_senha.setText(Prefs.getString("senha"))
        campo_check.isChecked = Prefs.getBoolean("campo_check")

        imageview_login.setImageResource(R.drawable.fenicelogo)
        botao_login.setOnClickListener {
            val textoUsuario = campo_usuario.text.toString()
            val textoSenha = campo_senha.text.toString()
            val valorCheck = campo_check.isChecked

            Prefs.setBoolean("campo_check", valorCheck)
            if (valorCheck) {
                Prefs.setString("nome_usuario",textoUsuario)
                Prefs.setString("senha", textoSenha)
            } else{
                Prefs.setString("nome_usuario","")
                Prefs.setString("senha", "")
            }


            var intent = Intent(this, TelaInicialActivity::class.java)

            val params = Bundle()
            params.putString("usuario", textoUsuario)

            intent.putExtras(params)

            if (textoUsuario.equals("aluno") && textoSenha.equals("impacta")) {
                Toast.makeText(this, "Dados validados com sucesso!", Toast.LENGTH_LONG).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha inválidos, tente novamente.", Toast.LENGTH_LONG).show()
            }
        }
    }
}