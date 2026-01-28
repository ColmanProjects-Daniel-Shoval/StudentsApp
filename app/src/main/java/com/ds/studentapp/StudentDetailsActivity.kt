package com.ds.studentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ds.studentapp.model.Model

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        intent.getStringExtra("studentId")?.let { studentId ->
            loadStudentDetails(studentId)

            findViewById<Button>(R.id.edit_button).setOnClickListener {
                val intent = Intent(this, EditStudentActivity::class.java)
                intent.putExtra("studentId", studentId)
                startActivity(intent)
            }
        }
    }
    override fun onResume() {
        super.onResume()
        intent.getStringExtra("studentId")?.let { studentId ->
            loadStudentDetails(studentId)
        }
    }

    private fun loadStudentDetails(studentId: String) {
        Model.getInstance().getStudentById(studentId)?.let {
            findViewById<TextView>(R.id.name_text).text = it.name
            findViewById<TextView>(R.id.id_text).text = it.id
            findViewById<TextView>(R.id.phone_text).text = it.phone
            findViewById<TextView>(R.id.address_text).text = it.address
            findViewById<CheckBox>(R.id.check).isChecked = it.checked
        } ?: run {
            finish()
        }
    }
}