package com.ds.studentapp.model

import com.ds.studentapp.R

class Model private constructor() {

    private var students: MutableList<Student> = ArrayList()

    val drawables = listOf(
        R.drawable.sponge,
        R.drawable.daniel,
        R.drawable.star,
        R.drawable.puff,
        R.drawable.mrkrabs,
        R.drawable.sandy
    )
    init {
        val characters = listOf(
            "SpongeBob SquarePants", "Patrick Star", "Squidward Tentacles",
            "Mr. Krabs", "Sandy Cheeks", "Sheldon J. Plankton",
            "Gary the Snail", "Mrs. Puff", "Pearl Krabs", "Larry the Lobster"
        )

        // Using the list size or a fixed number
        for (i in 0 until characters.size) {
            val randomImage = drawables.random()
            val student = Student(
                name = characters[i],
                id = "SB-${100 + i}", // Custom ID format like SB-100, SB-101
                phone = "02146158432$i",
                address = "Bikiny Bottom Clam Street $i",
                checked = i % 2 == 0,
                image = randomImage
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


    fun getRandomDrawable(): Int {
        return drawables.random()
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