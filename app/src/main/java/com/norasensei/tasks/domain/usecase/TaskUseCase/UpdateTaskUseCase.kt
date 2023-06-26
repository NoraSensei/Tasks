package com.norasensei.tasks.domain.usecase.TaskUseCase

import TaskRepository
import com.norasensei.tasks.domain.models.Task

class UpdateTaskUseCase (private val taskRepository: TaskRepository) {
	suspend fun execute(task: Task){
		taskRepository.updateTask(task);
	}
}
