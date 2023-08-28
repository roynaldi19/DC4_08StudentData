package com.roynaldi19.dc4_08studentdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.roynaldi19.dc4_08studentdata.database.Student
import com.roynaldi19.dc4_08studentdata.database.StudentAndUniversity
import com.roynaldi19.dc4_08studentdata.database.StudentWithCourse
import com.roynaldi19.dc4_08studentdata.database.UniversityAndStudent
import kotlinx.coroutines.launch

class MainViewModel(private val studentRepository: StudentRepository) : ViewModel() {

    init {
        insertAllData()
    }

    fun getAllStudent(): LiveData<List<Student>> = studentRepository.getAllStudent()

    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>> = studentRepository.getAllStudentAndUniversity()

    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> = studentRepository.getAllUniversityAndStudent()

    fun getAllStudentWhitCourse(): LiveData<List<StudentWithCourse>> = studentRepository.getAllStudentWhitCourse()

    private fun insertAllData() = viewModelScope.launch {
        studentRepository.insertAllData()
    }
}

class ViewModelFactory(private val repository: StudentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}