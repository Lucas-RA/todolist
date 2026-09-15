package lucasra.com.github.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//conexão com banco de dados
@Database(entities = [Tarefa::class], version = 2, exportSchema = false)
//classe abstrata - não vai instanciar objeto - só pode ser herdada
abstract class TarefaDatabase : RoomDatabase(){ // herda da dependência que vai criar o BD - RoomDatabase
    //função abstrata que herda da TarefaDAO
    abstract fun tarefaDao(): TarefaDAO

    // forma que o kotlin cria o objeto mais básico das classes
    companion object{
        @Volatile
        private var INSTANCE: TarefaDatabase? =null

        //função que recebe um contexto -> tudo aquilo sobre o qual a aplicação está rodando
        fun getDatabase(context: Context): TarefaDatabase{
            return INSTANCE ?: synchronized(this) {
                //chama o objeto Room do banco de dados - databaseBuilder >> Construir banco de dados
                //criando banco de dados usando contexto (Contexto >> Dispositivo: Android, versão do android, se já tem banco de dados, etc
                Room.databaseBuilder(
                context.applicationContext,
                TarefaDatabase::class.java,
                //nome do banco de dados
                "tarefas.db"
            ).fallbackToDestructiveMigration(dropAllTables = true)
                    .build()
                    .also {INSTANCE = it} // para criar sempre
            }
        }
    }
}