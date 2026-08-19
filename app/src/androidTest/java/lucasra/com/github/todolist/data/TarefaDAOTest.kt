package lucasra.com.github.todolist.data
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


//todo teste deve estar anotado com isso
@RunWith(AndroidJUnit4::class)
class TarefaDaoTest {

    //variáveis - criadas com private lateinit >> criamos já no construtor da classe
    private lateinit var database: TarefaDatabase //não nos interessa testar ele, mas precisamos para testar o DAO
    private lateinit var dao: TarefaDAO // objetivo dele é testar o acesso ao banco de dados


    //anotado com Before - ainda não é o teste, é a configuração dele - vai fazer primeiro
    @Before
    fun criarBanco() {
        //criar banco de dados em memoria - não podemos testar o que tiver na aplicação
        //criamos uma instância do banco de dados parecida em memória para os testes
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TarefaDatabase::class.java // usa isso para fazer a instância - não é o mesmo da aplicação (pois é em memória)
        ).allowMainThreadQueries().build()
        dao = database.tarefaDao()
    }

    //After - depois >> quando criarmos o teste para atualizar - acabando o teste do banco para atualizar, vai fechar o banco
    @After
    fun fecharBanco() {
        database.close()
    }

    //sistema reconhece que é um teste com essa anotação
    @Test
    fun inserirTarefaEListar() = runTest {
        //criando variável tarefa que instância o objeto tarefa
        //Cenário
        val tarefa = Tarefa(titulo = "Estudar Room", descricao = "Aprender Entity e DAO")
        //Execução
        //inserir que recebe a tarefa
        dao.inserir(tarefa)

        val tarefas = dao.listarTodas().first()
        //Validação
        assertEquals(1, tarefas.size)
        assertEquals("Estudar Room", tarefas[0].titulo)
        assertFalse(tarefas[0].concluida)
    }

}