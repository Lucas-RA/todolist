package lucasra.com.github.todolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// da acesso ao data access object
@Dao
//interface pois será implementada por outra classe
interface TarefaDAO{
    // marcamos a query que vai executar quando executar a função
    @Query("SELECT * FROM tarefas ORDER BY dataCriacao DESC")
    //obrigatoriamente quem implementar essa classe terá essa assinatura aqui
    fun listarTodas(): Flow<List<Tarefa>>


    //função de inserir que vai receber como parametro um objeto tarefa de Tarefa (todo o objeto Tarefa) - não só um id e sim o objeto inteiro
        //inteiro pois o objeto estará em uma lista - passaremos para a função e ela vai se virar
    @Insert
    suspend fun inserir(tarefa: Tarefa)

    @Update
    suspend fun atualizar(tarefa: Tarefa)

    @Delete
    suspend fun deletar(tarefa: Tarefa)
}