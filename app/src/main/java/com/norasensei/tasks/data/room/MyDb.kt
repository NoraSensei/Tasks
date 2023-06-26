package com.norasensei.tasks.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.norasensei.tasks.data.room.dao.TaskDao
import com.norasensei.tasks.data.room.dao.TaskListDao
import com.norasensei.tasks.data.room.entity.TaskEntity
import com.norasensei.tasks.data.room.entity.TaskListEntity

@Database(entities = [TaskListEntity::class, TaskEntity::class],version = 3)
abstract class MyDb : RoomDatabase() {
	abstract fun taskListDao(): TaskListDao
	abstract fun taskDao(): TaskDao

}