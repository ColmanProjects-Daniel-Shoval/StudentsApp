package com.ds.studentapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var studentList: StudentListFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        studentList = StudentListFragment()
        replaceFragment(R.id.main_activity_frame_layout, studentList, "TAG")
    }
    private fun replaceFragment(containerId: Int, fragment: Fragment, tag: String? = null) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(containerId, fragment, tag)
            addToBackStack(tag)
        }
    }
}