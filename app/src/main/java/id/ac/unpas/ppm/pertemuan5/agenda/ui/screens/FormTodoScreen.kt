package id.ac.unpas.ppm.pertemuan5.agenda.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.benasher44.uuid.uuid4
import id.ac.unpas.ppm.pertemuan5.agenda.models.Todo
import id.ac.unpas.ppm.pertemuan5.agenda.persistences.TodoDao
import kotlinx.coroutines.launch

// Allfiandi Rahman
// 213040052
// Praktikum Pemrograman Mobile [Kelas A]
// Pertemuan 5 = Android Room
// 08 Maret 2024

@Composable
fun FormTodoScreen(todoDao: TodoDao) {

    val scope = rememberCoroutineScope()

    val title = remember { mutableStateOf(TextFieldValue("")) }
    val description = remember { mutableStateOf(TextFieldValue("")) }
    val dueDate = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = {Text(text = "Title")},
            modifier = Modifier.fillMaxWidth(),
            value = title.value, onValueChange = {
            title.value = it
        })

        OutlinedTextField(
            label = {Text(text = "Description")},
            modifier = Modifier.fillMaxWidth(),
            value = description.value, onValueChange = {
            description.value = it
        })

        OutlinedTextField(
            label = {Text(text = "Due Date")},
            modifier = Modifier.fillMaxWidth(),
            value = dueDate.value, onValueChange = {
            dueDate.value = it
        })

        Row {
            Button(modifier = Modifier.weight(5f), onClick = {
                // simpan ke database
                val item = Todo(uuid4().toString(), title.value.text, description.value.text, dueDate.value.text)
                scope.launch {
                    todoDao.upsert(item)
                }
                title.value = TextFieldValue("")
                description.value = TextFieldValue("")
                dueDate.value = TextFieldValue("")
            }) {
                Text(text = "Simpan")
            }

            Button(modifier = Modifier.weight(5f), onClick = {
                // kembali ke halaman sebelumnya
                title.value = TextFieldValue("")
                description.value = TextFieldValue("")
                dueDate.value = TextFieldValue("")
            }) {
                Text(text = "Batal")
            }
        }
    }
}