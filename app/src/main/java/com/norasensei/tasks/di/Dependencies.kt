package com.norasensei.tasks.di

import TaskRepository
import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.norasensei.tasks.data.repositoryImpl.TaskListRepository
import com.norasensei.tasks.data.room.MyDb

@SuppressLint("StaticFieldLeak")
object Dependencies {

	lateinit var context: Context;

	fun init(context: Context){
		Dependencies.context = context;
	}

	private val db by lazy {
		Room.databaseBuilder(context, MyDb::class.java,"task_db_01.db")
			.fallbackToDestructiveMigration()
			.createFromAsset("databases/task_db_01.db")
			.build()
	}

	val taskListRepository by lazy {
		TaskListRepository(db.taskListDao())
	}

	val taskRepository by lazy {
		TaskRepository(db.taskDao())
	}
}