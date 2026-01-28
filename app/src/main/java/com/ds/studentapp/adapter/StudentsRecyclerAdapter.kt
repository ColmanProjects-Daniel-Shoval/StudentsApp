package com.ds.studentapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ds.studentapp.OnItemClickListener
import com.ds.studentapp.R
import com.ds.studentapp.model.Model
import com.ds.studentapp.model.Student

class StudentsRecyclerAdapter(private val onItemClickListener: OnItemClicked): RecyclerView.Adapter<StudentViewHolder>() {
        fun interface OnItemClicked {
            fun onItemClicked(studentId: String)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val inflation = LayoutInflater.from(parent.context)
            val view = inflation.inflate(R.layout.student_list_row, parent, false)
            return StudentViewHolder(view)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            holder.bind(Model.getInstance().getStudents()[position], onItemClickListener)
        }
        override fun getItemCount(): Int {
            return Model.getInstance().getStudentsCount()
        }
    }