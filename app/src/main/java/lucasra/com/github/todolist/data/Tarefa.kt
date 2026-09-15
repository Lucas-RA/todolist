package lucasra.com.github.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tarefas")
data class Tarefa(
    //classe que tem um esqueleto de como vai ser a tabela
    //atributo id
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val descricao: String,
    val concluida: Boolean = false,
//    ajustamos para incluir a dataEHora da tarefa
    val dataCriacao: Long = System.currentTimeMillis(),
    val dataHora: Long? = null
)
