package lucasra.com.github.todolist.repository

import lucasra.com.github.todolist.data.Tarefa
import lucasra.com.github.todolist.data.TarefaDAO
import kotlinx.coroutines.flow.Flow

// repository onde vamos mapear os métodos do CRUD
class TarefaRepository(private val dao: TarefaDAO){

    val tarefas: Flow<List<Tarefa>> = dao.listarTodas();

    suspend fun inserir(tarefa: Tarefa) = dao.inserir(tarefa);

    suspend fun atualizar(tarefa: Tarefa) = dao.atualizar(tarefa);

    suspend fun deletar(tarefa: Tarefa) = dao.deletar(tarefa);
}