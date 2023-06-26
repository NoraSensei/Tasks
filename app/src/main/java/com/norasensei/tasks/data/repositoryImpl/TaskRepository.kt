import com.norasensei.tasks.data.Mapper
import com.norasensei.tasks.data.room.dao.TaskDao
import com.norasensei.tasks.domain.ITaskRepository
import com.norasensei.tasks.domain.models.Task

class TaskRepository(private val taskDao: TaskDao) : ITaskRepository {

	private val mapper = Mapper()

	override suspend fun addTask(task: Task) {
		taskDao.addTask(mapper.taskToTaskEntity(task))
	}

	override suspend fun deleteTask(task: Task) {
		taskDao.deleteTask(mapper.taskToTaskEntity(task))
	}

	override suspend fun getTasksFromTaskList(id: Int): List<Task> {
		return taskDao.getTasksFromTaskList(id).map {
			mapper.taskEntityToTask(it)
		}
	}

	override suspend fun addTaskToFavouriteTaskList(task: Task) {
		taskDao.addTaskToFavouriteTaskList(mapper.taskToTaskEntity(task).id)

	}

	override suspend fun removeTaskFromFavouriteTaskList(task: Task) {
		taskDao.removeTaskFromFavouriteTaskList(mapper.taskToTaskEntity(task).id)
	}

	override suspend fun getFavouriteTasks(): List<Task> {
		return taskDao.getFavouriteTasks().map {
			mapper.taskEntityToTask(it)
		}
	}

	override suspend fun updateTask(task: Task) {
		taskDao.updateTask(mapper.taskToTaskEntity(task))
	}


}