package com.ds.studentapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ds.studentapp.adapter.StudentsRecyclerAdapter
import com.ds.studentapp.model.Model
import com.ds.studentapp.model.Student

interface OnItemClickListener {
    fun onItemClick(position: Int)
    fun onItemClick(student: Student?)
}
class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView: RecyclerView = findViewById(R.id.students_list_activity_recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = createAdapter()

        val addStudentButton: Button = findViewById(R.id.add_student_button)

        addStudentButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<RecyclerView>(R.id.students_list_activity_recycler_view).adapter = createAdapter()
    }
    private fun createAdapter(): StudentsRecyclerAdapter {
        return StudentsRecyclerAdapter { studentId ->

        }
    }
}