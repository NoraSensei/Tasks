package com.norasensei.tasks.data

import com.norasensei.tasks.data.room.entity.TaskEntity
import com.norasensei.tasks.data.room.entity.TaskListEntity
import com.norasensei.tasks.domain.models.Task
import com.norasensei.tasks.domain.models.TaskList

class Mapper {
	fun taskListEntityToTaskList(taskListEntity: TaskListEntity): TaskList {
		return TaskList(taskListEntity.name,taskListEntity.isFavourite,taskListEntity.id)
	}
	 fun taskListToTaskListEntity(taskList: TaskList) : TaskListEntity {
		return TaskListEntity(taskList.id, taskList.name,taskList.isFavourite)
	}

	fun taskToTaskEntity(task: Task): TaskEntity {
		return TaskEntity(task.id,task.name,task.description,task.taskListId,task.isFavourite,task.createDate)
	}
	fun taskEntityToTask(task: TaskEntity): Task {
		return Task(task.name,task.description,task.taskListId,task.isFavourite,task.id,)
	}
}