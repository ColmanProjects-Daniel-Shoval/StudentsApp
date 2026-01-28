package com.ds.studentapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ds.studentapp.model.Model
import com.ds.studentapp.model.Student

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.cancel_button).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.save_button).setOnClickListener {
            saveStudent()
            finish()
        }
    }
    private fun saveStudent() {
        val nameInput: EditText = findViewById(R.id.name_input)
        val idInput: EditText = findViewById(R.id.id_input)
        val phoneInput: EditText = findViewById(R.id.phone_input)
        val addressInput: EditText = findViewById(R.id.address_input)
        val checkBoxInput: CheckBox = findViewById(R.id.check_input)

        val newStudent = Student(
            idInput.text.toString(),
            nameInput.text.toString(),
            phoneInput.text.toString(),
            addressInput.text.toString(),
            checkBoxInput.isChecked
        )

        Model.getInstance().addStudent(newStudent)
    }
}