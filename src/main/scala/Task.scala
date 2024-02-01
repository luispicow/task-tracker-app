package tasktrackerapp

class Task(description: String, dueDate: String, status: TaskStatus = TaskStatus.New, priority: TaskPriority) {
  def getDescription: String = description
  def getDueDate: String = dueDate
  def getStatus: TaskStatus = status
  def getPriority: TaskPriority = priority
  def changeStatus(status: TaskStatus): Task = Task(description, dueDate, status, priority)
  override def toString: String = s"Task: $description, Due Date: $dueDate, Status: $status, Priority: $priority"
}
