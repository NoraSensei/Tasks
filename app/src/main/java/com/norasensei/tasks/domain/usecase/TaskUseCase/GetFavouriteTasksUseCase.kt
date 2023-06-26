package com.norasensei.tasks.domain.usecase.TaskUseCase

import TaskRepository
import com.norasensei.tasks.domain.models.Task

class GetFavouriteTasksUseCase (private val taskRepository: TaskRepository) {
	suspend fun execute():List<Task>{
		return taskRepository.getFavouriteTasks();
	}
}