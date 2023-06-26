package com.norasensei.tasks.domain.usecase.TaskListUseCase

import com.norasensei.tasks.domain.ITaskListRepository
import com.norasensei.tasks.domain.models.TaskList

class AddTaskListUseCase(private val taskListRepository: ITaskListRepository) {
	suspend fun execute(taskList: TaskList){
		taskListRepository.addTaskList(taskList);
	}
}