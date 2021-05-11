package br.com.fenicearteejoias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

open class NavigationDrawerActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun configuraMenuLateral(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //configuraMenuLateral()

        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        layoutMenuLateral.addDrawerListener(toogle)//Link de quando clicar no toogle
        toogle.syncState()
        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //Verificar em qual item foi clicado
        when (item.itemId) {
            R.id.nav_produtos -> {
                Toast.makeText(this, "Clicou em Produtos", Toast.LENGTH_SHORT). show()
            }
            R.id.nav_faleconosco -> {
                Toast.makeText(this, "Clicou em Fale Conosco", Toast.LENGTH_SHORT). show()
                var intent = Intent(this, ForumActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_encomendar -> {
                Toast.makeText(this, "Clicou em Encomendar", Toast.LENGTH_SHORT).show()
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)//Fechar o menu
        return true
    }
}