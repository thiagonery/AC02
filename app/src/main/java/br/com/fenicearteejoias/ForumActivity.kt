package br.com.fenicearteejoias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class ForumActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)
        configuraMenuLateral()

        menu_lateral.setCheckedItem(R.id.nav_faleconosco)
    }
}