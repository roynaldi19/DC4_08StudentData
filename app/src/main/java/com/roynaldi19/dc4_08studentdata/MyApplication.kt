package com.roynaldi19.dc4_08studentdata

import android.app.Application
import com.roynaldi19.dc4_08studentdata.database.StudentDatabase

class MyApplication : Application() {
    val database by lazy { StudentDatabase.getDatabase(this) }
    val repository by lazy { StudentRepository(database.studentDao())}
}