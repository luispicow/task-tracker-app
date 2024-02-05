package tasktrackerapp

import java.util.UUID

/**
 * A class representing a user's tasks.
 *
 * @constructor create a new user with a username and a list of tasks.
 * @param username the name of the user.
 * @param tasks the list of tasks.
 */
class MyTasks(val username: String, val tasks: List[Task] = List()) {

  /**
   * Add a new task to the user's tasks.
   * @param task the task to add.
   * @return a new MyTasks instance with the added task.
   */
  def addTask(task: Task): MyTasks = MyTasks(username, task :: tasks)

  /**
   * Activate a task.
   * @param taskId the ID of the task to activate.
   * @return a new MyTasks instance with the activated task.
   */
  def activateTask(taskId: UUID): MyTasks = MyTasks(username, tasks.map(t => if (t.getId == taskId) t.changeStatus(TaskStatus.Active) else t))

  /**
   * Complete a task.
   * @param taskId the ID of the task to complete.
   * @return a new MyTasks instance with the completed task.
   */
  def completeTask(taskId: UUID): MyTasks = MyTasks(username, tasks.map(t => if (t.getId == taskId) t.changeStatus(TaskStatus.Completed) else t))

  /**
   * Delete a task.
   * @param taskId the ID of the task to delete.
   * @return a new MyTasks instance without the deleted task.
   */
  def deleteTask(taskId: UUID): MyTasks = MyTasks(username, tasks.filterNot(t => t.getId == taskId))

  /**
   * Change the priority of a task.
   * @param taskId the ID of the task to change.
   * @param priority the new priority.
   * @return a new MyTasks instance with the task's priority changed.
   */
  def changeTaskPriority(taskId: UUID, priority: TaskPriority.TaskPriority): MyTasks = MyTasks(username, tasks.map(t => if (t.getId == taskId) t.changePriority(priority) else t))

  /**
   * Sort the tasks.
   * @param sortBy the attribute to sort by. It can be either "priority" or "dueDate".
   * @return a new MyTasks instance with the tasks sorted.
   */
  def sortTasks(sortBy: String): MyTasks = {
    val sortedTasks = sortBy match {
      case "priority" => tasks.sortBy(_.priority)(TaskPriority.taskPriorityOrdering)
      case "dueDate" => tasks.sortBy(_.dueDate)
      case _ => tasks
    }

    MyTasks(username, sortedTasks)
  }

  /**
   * Convert the MyTasks instance to a string.
   * @return a string representation of the MyTasks instance.
   */
  override def toString: String = {
    s"User: $username\nTasks:\n${tasks.map(task => s"(${task.toString})").mkString("\n")}"
  }
}