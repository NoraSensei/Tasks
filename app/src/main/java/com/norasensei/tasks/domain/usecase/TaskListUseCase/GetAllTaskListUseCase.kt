package com.norasensei.tasks.domain.usecase.TaskListUseCase

import com.norasensei.tasks.domain.ITaskListRepository
import com.norasensei.tasks.domain.models.TaskList

class GetAllTaskListUseCase (private val TaskListRepository: ITaskListRepository) {
	suspend fun execute() :List<TaskList> {
		return TaskListRepository.getAllTaskLists()
	}
}