package com.norasensei.tasks.domain

import com.norasensei.tasks.domain.models.Task

interface ITaskRepository {
	suspend fun addTask(task: Task)
	suspend fun deleteTask(task: Task)
	suspend fun getTasksFromTaskList(id: Int) : List<Task>
	suspend fun addTaskToFavouriteTaskList(task: Task)
	suspend fun removeTaskFromFavouriteTaskList(task: Task)
	suspend fun getFavouriteTasks() : List<Task>
	suspend fun updateTask(task: Task)
}