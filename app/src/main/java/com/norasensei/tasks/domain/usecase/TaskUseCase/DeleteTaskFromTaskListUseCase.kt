package com.norasensei.tasks.domain.usecase.TaskUseCase

import TaskRepository
import com.norasensei.tasks.domain.models.Task

class DeleteTaskFromTaskListUseCase(private val taskRepository: TaskRepository) {
	suspend fun execute(task: Task){
		taskRepository.deleteTask(task);
	}

}