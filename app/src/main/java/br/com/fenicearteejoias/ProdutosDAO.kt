package br.com.fenicearteejoias

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProdutosDAO {
    @Query("SELECT * FROM produtos WHERE ID= :id")
    fun getById(id: Long): Produtos?

    @Query("SELECT * FROM produtos")
    fun findAll(): List<Produtos>

    @Insert
    fun insert(produtos: Produtos)

    @Delete
    fun delete(produto: Produtos)
}