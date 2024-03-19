package id.ac.unpas.ppm.pertemuan5.agenda.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// Allfiandi Rahman
// 213040052
// Praktikum Pemrograman Mobile [Kelas A]
// Pertemuan 5 = Android Room
// 08 Maret 2024

@Entity
data class Todo(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val dueDate: String
)
