package com.norasensei.tasks.domain.usecase.TaskListUseCase

import com.norasensei.tasks.domain.ITaskListRepository
import com.norasensei.tasks.domain.models.TaskList

class RenameTaskListUseCase (private  val repository: ITaskListRepository) {
	suspend fun execute(taskList: TaskList, newName:String){
		taskList.name = newName
		repository.updateTaskList(taskList);
	}
}