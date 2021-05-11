package br.com.fenicearteejoias

object ProdutosService {
    fun getProdutos(): List<Produtos>{
        val produtos = mutableListOf<Produtos>()

        for (i in 1..10) {
            var prod = Produtos()
            prod.nome = "Produto $i"
            prod.descricao = "Descrição $i"
            //prod.preco = "Preço $i"
            prod.foto = "https://img.irroba.com.br/fit-in/600x600/filters:format(webp):fill(fff):quality(95)/fabricad/catalog/produtos/aneis/101266/solitario-11.jpg"
            produtos.add(prod)
        }
        return produtos
    }
}