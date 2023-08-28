package com.roynaldi19.dc4_08studentdata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roynaldi19.dc4_08studentdata.database.StudentAndUniversity
import com.roynaldi19.dc4_08studentdata.database.StudentWithCourse
import com.roynaldi19.dc4_08studentdata.databinding.ItemStudentBinding

class StudentWhitCourseAdapter :
    ListAdapter<StudentWithCourse, StudentWhitCourseAdapter.WordViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WordViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: StudentWithCourse) {
            binding.tvItemName.text = data.student.name
            val arrayCourse = arrayListOf<String>()
            data.course.forEach{
                arrayCourse.add(it.name)
            }
            binding.tvItemCourse.text = arrayCourse.joinToString(separator = ", ")
            binding.tvItemUniversity.visibility = View.VISIBLE
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<StudentWithCourse>() {
        override fun areItemsTheSame(oldItem: StudentWithCourse, newItem: StudentWithCourse): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: StudentWithCourse, newItem: StudentWithCourse): Boolean {
            return oldItem.student.name == newItem.student.name
        }
    }

}