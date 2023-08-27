package com.roynaldi19.dc4_08studentdata

import androidx.lifecycle.LiveData
import com.roynaldi19.dc4_08studentdata.database.Student
import com.roynaldi19.dc4_08studentdata.database.StudentAndUniversity
import com.roynaldi19.dc4_08studentdata.database.StudentDao
import com.roynaldi19.dc4_08studentdata.helper.InitialDataSource

class StudentRepository(private val studentDao: StudentDao) {
    fun getAllStudent(): LiveData<List<Student>> = studentDao.getAllStudent()
    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>> = studentDao.getAllStudentAndUniversity()

    suspend fun insertAllData() {
        studentDao.insertStudent(InitialDataSource.getStudents())
        studentDao.insertUniversity(InitialDataSource.getUniversities())
        studentDao.insertCourse(InitialDataSource.getCourses())
    }
}