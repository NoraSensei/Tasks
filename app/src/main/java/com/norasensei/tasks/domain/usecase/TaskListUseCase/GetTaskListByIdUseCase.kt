package com.norasensei.tasks.domain.usecase.TaskListUseCase

import com.norasensei.tasks.domain.ITaskListRepository
import com.norasensei.tasks.domain.models.TaskList

class GetTaskListByIdUseCase(private val taskListRepository: ITaskListRepository) {
	suspend fun execute(taskListId:Int): TaskList? {
		return taskListRepository.getTaskList(taskListId)
	}
}