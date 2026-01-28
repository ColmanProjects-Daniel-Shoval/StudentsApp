package com.ds.studentapp.adapter
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ds.studentapp.OnItemClickListener
import com.ds.studentapp.R
import com.ds.studentapp.model.Model
import com.ds.studentapp.model.Student

class StudentViewHolder(
    itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.studentName)
        private val id: TextView = itemView.findViewById(R.id.studentId)
        private val checkBox: CheckBox = itemView.findViewById(R.id.studentCheck)

        fun bind(student: Student, onItemClickListener: StudentsRecyclerAdapter.OnItemClicked) {
            name.text = student.name
            id.text = student.id
            checkBox.isChecked = student.checked

            checkBox.setOnCheckedChangeListener { _, isChecked ->
                student.checked = isChecked
            }

            itemView.setOnClickListener {
                onItemClickListener.onItemClicked(student.id)
            }
        }
    }