package com.nibm.procrastinatorstodo

import android.graphics.Color // Import this
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nibm.procrastinatorstodo.databinding.TaskListItemBinding

class TaskAdapter(private val taskList: ArrayList<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(val binding: TaskListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TaskListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = taskList[position]

        holder.binding.apply {
            lblTaskTitle.text = currentTask.title
            lblTaskDue.text = currentTask.dueDate
            lblTaskPriority.text = currentTask.priority

            // --- NEW: Background Color Logic ---

            val colorCode = when (currentTask.priority) {
                "High" -> "#FFCDD2"   // Light Red
                "Medium" -> "#FFE0B2" // Light Orange
                "Low" -> "#C8E6C9"    // Light Green
                else -> "#FFFFFF"     // White (Default)
            }

            // Apply color to the whole item container
            root.setBackgroundColor(Color.parseColor(colorCode))

            // Optional: Make text black so it stands out against the colored background
            lblTaskPriority.setTextColor(Color.BLACK)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}