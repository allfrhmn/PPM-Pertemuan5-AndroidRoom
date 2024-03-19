package id.ac.unpas.ppm.pertemuan5.agenda.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import id.ac.unpas.ppm.pertemuan5.agenda.models.Todo
import id.ac.unpas.ppm.pertemuan5.agenda.persistences.TodoDao

// Allfiandi Rahman
// 213040052
// Praktikum Pemrograman Mobile [Kelas A]
// Pertemuan 5 = Android Room
// 08 Maret 2024

@Composable
fun ListTodoScreen(todoDao: TodoDao) {

    val _list: LiveData<List<Todo>> = todoDao.loadAll()
    val list: List<Todo> by _list.observeAsState(listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(list.size) { index ->
                val item = list[index]
                TodoItem(item)
            }
        }
    }
}