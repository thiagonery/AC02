package br.com.fenicearteejoias

import java.io.Serializable

class Produtos: Serializable {

    var id: Long = 0
    var nome = ""
    var descricao = ""
    var foto = ""
    var preco: Float = 0F
}