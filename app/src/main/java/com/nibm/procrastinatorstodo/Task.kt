package com.nibm.procrastinatorstodo

data class Task(
    val title: String,
    val description: String,
    val dueDate: String,
    val priority: String,
    val reminder: String?
)
