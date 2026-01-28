package com.ds.studentapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ds.studentapp.model.Model
import com.ds.studentapp.model.Student

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val studentId = intent.getStringExtra("studentId")

        if(studentId == null) {
            finish()
            return
        }

        loadStudentDetails(studentId)

        findViewById<Button>(R.id.cancel_button).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.save_button).setOnClickListener {
            updateStudentDetails(studentId)
        }

        findViewById<Button>(R.id.delete_button).setOnClickListener {
            deleteStudent(studentId)
        }
    }

    private fun loadStudentDetails(studentId: String) {
        Model.getInstance().getStudentById(studentId)?.let {
            findViewById<TextView>(R.id.name_input).text = it.name
            findViewById<TextView>(R.id.id_input).text = it.id
            findViewById<TextView>(R.id.phone_input).text = it.phone
            findViewById<TextView>(R.id.address_input).text = it.address
            findViewById<CheckBox>(R.id.check_input).isChecked = it.checked
        }
    }

    private fun updateStudentDetails(studentId: String) {
        val student = Student(
            findViewById<TextView>(R.id.id_input).text.toString(),
            findViewById<TextView>(R.id.name_input).text.toString(),
            findViewById<TextView>(R.id.phone_input).text.toString(),
            findViewById<TextView>(R.id.address_input).text.toString(),
            findViewById<CheckBox>(R.id.check_input).isChecked,
            Model.getInstance().getStudentById(studentId)?.image ?: R.drawable.sponge
        )
        Model.getInstance().updateStudentById(studentId, student)
        finish()
    }

    private fun deleteStudent(studentId: String) {
        Model.getInstance().deleteStudentById(studentId)
        finish()
    }
}