package com.ds.studentapp.model

class Model private constructor() {

    private var students: MutableList<Student> = ArrayList()

    init {
        for (i in 0..20) {
            val student = Student(
                name = "Name $i",
                id = "Student ID: $i",
                phone = "Phone $i",
                address = "Address $i",
                checked  = false
            )
            students.add(student)
        }
    }

    companion object {
        private val instance = Model()

        fun getInstance(): Model {
            return instance
        }
    }


    fun addStudent(student: Student) {
        students.add(student)
    }

    fun getStudents(): List<Student> {
        return students
    }

    fun getStudentsCount(): Int {
        return students.size
    }

    fun getStudentById(studentId: String): Student? {
        return students.find { it.id == studentId }
    }

    fun updateStudentById(studentId: String, student: Student) {
        val index = students.indexOfFirst { it.id == studentId }

        if (index != -1) {
            students[index] = student
        }
    }

    fun deleteStudentById(studentId: String) {
        students.removeIf { it.id == studentId }
    }



}