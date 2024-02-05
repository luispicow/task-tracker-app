package tasktrackerapp

import java.util.UUID

/**
 * A class representing a task.
 *
 * @constructor create a new task with a description, due date, priority, status and a unique ID.
 * @param description the description of the task.
 * @param dueDate the due date of the task.
 * @param priority the priority of the task.
 * @param status the status of the task, default is New.
 * @param id the unique ID of the task, default is a random UUID.
 */
class Task(val description: String, val dueDate: java.time.LocalDate, val priority: TaskPriority.TaskPriority = TaskPriority.Low, val status: TaskStatus = TaskStatus.New, private val id: UUID = UUID.randomUUID()) {

  /**
   * Get the ID of the task.
   * @return the unique ID of the task.
   */
  def getId: UUID = id

  /**
   * Change the status of the task.
   * @param status the new status.
   * @return a new Task instance with the status changed.
   */
  def changeStatus(status: TaskStatus): Task = Task(description, dueDate, priority, status, id)

  /**
   * Change the priority of the task.
   * @param priority the new priority.
   * @return a new Task instance with the priority changed.
   */
  def changePriority(priority: TaskPriority.TaskPriority): Task = Task(description, dueDate, priority, status, id)

  /**
   * Convert the Task instance to a string.
   * @return a string representation of the Task instance.
   */
  override def toString: String = s"Id:$id, Description: $description, Due date: $dueDate, Priority: $priority, Status: $status"
}