package br.com.fenicearteejoias

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "produtos")
class Produtos: Serializable {

    @PrimaryKey
    var id: Long? = null
    var nome = ""
    var descricao = ""
    var foto = ""
    var preco: Float = 0F

    override fun toString(): String {
        return "Disciplina(nome='$nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}