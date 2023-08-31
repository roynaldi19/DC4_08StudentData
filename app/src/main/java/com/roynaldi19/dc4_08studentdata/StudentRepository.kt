package com.roynaldi19.dc4_08studentdata

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.roynaldi19.dc4_08studentdata.database.Student
import com.roynaldi19.dc4_08studentdata.database.StudentAndUniversity
import com.roynaldi19.dc4_08studentdata.database.StudentDao
import com.roynaldi19.dc4_08studentdata.database.StudentWithCourse
import com.roynaldi19.dc4_08studentdata.database.UniversityAndStudent
import com.roynaldi19.dc4_08studentdata.helper.InitialDataSource
import com.roynaldi19.dc4_08studentdata.helper.SortType
import com.roynaldi19.dc4_08studentdata.helper.SortUtils

class StudentRepository(private val studentDao: StudentDao) {
    fun getAllStudent(sortType: SortType): LiveData<PagedList<Student>> {
        val query = SortUtils.getSortedQuery(sortType)
        val student = studentDao.getAllStudent(query)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(30)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(student, config).build()
    }
    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>> = studentDao.getAllStudentAndUniversity()
    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> = studentDao.getAllUniversityAndStudent()
    fun getAllStudentWhitCourse(): LiveData<List<StudentWithCourse>> = studentDao.getAllStudentWithCourse()

}