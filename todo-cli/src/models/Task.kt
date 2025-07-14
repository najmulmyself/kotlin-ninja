package models

data class Task(
    val id: Int,
    val title: String,
    val desc: String,
    var isDone: Boolean = false,
)