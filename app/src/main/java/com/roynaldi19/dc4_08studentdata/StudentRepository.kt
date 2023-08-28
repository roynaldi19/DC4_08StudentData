package com.roynaldi19.dc4_08studentdata

import androidx.lifecycle.LiveData
import com.roynaldi19.dc4_08studentdata.database.Student
import com.roynaldi19.dc4_08studentdata.database.StudentAndUniversity
import com.roynaldi19.dc4_08studentdata.database.StudentDao
import com.roynaldi19.dc4_08studentdata.database.StudentWithCourse
import com.roynaldi19.dc4_08studentdata.database.UniversityAndStudent
import com.roynaldi19.dc4_08studentdata.helper.InitialDataSource
import com.roynaldi19.dc4_08studentdata.helper.SortType
import com.roynaldi19.dc4_08studentdata.helper.SortUtils

class StudentRepository(private val studentDao: StudentDao) {
    fun getAllStudent(sortType: SortType): LiveData<List<Student>> {
        val query = SortUtils.getSortedQuery(sortType)
        return studentDao.getAllStudent(query)
    }
    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>> = studentDao.getAllStudentAndUniversity()
    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> = studentDao.getAllUniversityAndStudent()
    fun getAllStudentWhitCourse(): LiveData<List<StudentWithCourse>> = studentDao.getAllStudentWithCourse()

}