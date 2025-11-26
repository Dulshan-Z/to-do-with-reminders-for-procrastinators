package com.nibm.procrastinatorstodo

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nibm.procrastinatorstodo.databinding.ActivityAddTaskBinding
import java.util.Calendar

class AddTask : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Date Picker for due date
        binding.edtTaskDate.setOnClickListener {
            val c = Calendar.getInstance()
            val dp = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    binding.edtTaskDate.setText("$dayOfMonth/${month + 1}/$year")
                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
            )
            dp.show()
        }

        // Submit Button
        binding.btnSubmitTask.setOnClickListener {
            val task = Task(
                title = binding.edtTaskTitle.text.toString(),
                description = binding.edtTaskDescription.text.toString(),
                dueDate = binding.edtTaskDate.text.toString(),
                priority = binding.spinnerPriority.selectedItem.toString(),
                reminder = binding.edtCustomReminder.text.toString()
            )

            val intent = Intent().apply {
                putExtra("task_title", task.title)
                putExtra("task_desc", task.description)
                putExtra("task_due", task.dueDate)
                putExtra("task_priority", task.priority)
                putExtra("task_reminder", task.reminder)
            }

            setResult(RESULT_OK, intent)
            finish()
        }

        // Cancel Button
        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}
