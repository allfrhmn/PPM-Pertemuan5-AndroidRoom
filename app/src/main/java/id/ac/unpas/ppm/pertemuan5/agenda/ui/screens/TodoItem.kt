package id.ac.unpas.ppm.pertemuan5.agenda.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.ac.unpas.ppm.pertemuan5.agenda.models.Todo

// Allfiandi Rahman
// 213040052
// Praktikum Pemrograman Mobile [Kelas A]
// Pertemuan 5 = Android Room
// 08 Maret 2024

@Composable
fun TodoItem(item: Todo) {
    Row {
        Text(modifier = Modifier.weight(3f), text = item.title)
        Text(modifier = Modifier.weight(3f), text = item.description)
        Text(modifier = Modifier.weight(3f), text = item.dueDate)
    }
}