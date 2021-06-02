package br.com.fenicearteejoias

import java.net.URL
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ProdutosService {

    val host = "https://fesousa.pythonanywhere.com"//Futuramente alterar
    val TAG = "WS_FENICE"

    fun getProdutos(): List<Produtos>{
        val url = "$host/disciplinas"
        val json = httpHelper.get(url)

        Log.d(TAG, json)
        var produtos = parserJson<List<Produtos>>(json)

        return produtos
    }

    fun saveProduto(produto: Produtos){
        val json = produto.toJson()
        httpHelper.post("$host/disciplinas", json)//Futuramente alterar
    }

    inline fun<reified T> parserJson(json: String): T {
        var type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}