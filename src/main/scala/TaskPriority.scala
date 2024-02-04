package tasktrackerapp

/**
 * An enumeration representing task priorities.
 */
object TaskPriority extends Enumeration {
  type TaskPriority = Value

  val High, Medium, Low = Value

  /**
   * An implicit ordering for TaskPriority values.
   */
  implicit val taskPriorityOrdering: Ordering[TaskPriority] = Ordering.by(priorityValues)

  /**
   * Convert TaskPriority values to integers for ordering.
   * @param priority the TaskPriority value.
   * @return an integer representing the priority.
   */
  private def priorityValues(priority: TaskPriority): Int = priority match {
    case High   => 1
    case Medium => 2
    case Low    => 3
  }
}