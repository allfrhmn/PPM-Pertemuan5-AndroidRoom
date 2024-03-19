package id.ac.unpas.ppm.pertemuan5.agenda.persistences

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.unpas.ppm.pertemuan5.agenda.models.Todo

// Allfiandi Rahman
// 213040052
// Praktikum Pemrograman Mobile [Kelas A]
// Pertemuan 5 = Android Room
// 08 Maret 2024

@Dao
interface TodoDao {
    @Query("select * from todo")
    fun loadAll(): LiveData<List<Todo>>

    @Query("select * from todo where id = :id")
    fun load(id: String): LiveData<Todo>

    @Query("select * from todo where id = :id")
    suspend fun getById(id: String): Todo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(vararg items: Todo)

    @Query("delete from todo where id = :id")
    suspend fun delete(id: String)

    @Delete
    suspend fun delete(item: Todo)
}