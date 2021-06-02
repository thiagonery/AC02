package br.com.fenicearteejoias

import android.app.Application
import java.lang.IllegalStateException

class Application:Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
    companion object {
        private var appInstance: Application? = null

        fun getInstance(): Application {
            if(appInstance == null){
                throw IllegalStateException("Configurar application no Manifest.")
            }
            return appInstance!!
        }
    }
}