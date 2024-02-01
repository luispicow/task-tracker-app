package tasktrackerapp
object App extends App {
  val task1: Task = Task(description = "First task", dueDate = "2024-02-02", priority = TaskPriority.Low)

  println(task1)
}
