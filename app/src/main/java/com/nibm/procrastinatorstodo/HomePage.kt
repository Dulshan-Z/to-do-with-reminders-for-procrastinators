package com.nibm.procrastinatorstodo

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nibm.procrastinatorstodo.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    private val taskList = ArrayList<Task>()
    private lateinit var adapter: TaskAdapter

    private val addTaskLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data!!
            val task = Task(
                data.getStringExtra("task_title")!!,
                data.getStringExtra("task_desc")!!,
                data.getStringExtra("task_due")!!,
                data.getStringExtra("task_priority")!!,
                data.getStringExtra("task_reminder")
            )
            taskList.add(task)
            adapter.notifyItemInserted(taskList.size - 1)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView
        adapter = TaskAdapter(taskList)
        binding.rcyTasks.layoutManager = LinearLayoutManager(this)
        binding.rcyTasks.adapter = adapter

        // Add Task Button
        binding.btnAddTask.setOnClickListener {
            val intent = Intent(this, AddTask::class.java)
            addTaskLauncher.launch(intent)
        }

        // Optional: set SearchView height in XML instead of programmatically
    }
}
