package com.norasensei.tasks.domain.usecase.TaskListUseCase

import com.norasensei.tasks.domain.ITaskListRepository
import com.norasensei.tasks.domain.models.TaskList

class DeleteTaskListUseCase(private val taskListRepository: ITaskListRepository) {
	suspend fun execute(taskList: TaskList){
		taskListRepository.deleteTaskList(taskList);
	}
	suspend fun execute(id: Int){
		taskListRepository.deleteTaskList(id);
	}
}