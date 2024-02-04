package tasktrackerapp

import java.time.LocalDate

object App extends App {
  var luisTasks: MyTasks = MyTasks("Luis")

  val task1: Task = Task("First task", LocalDate.of(2024, 2, 4), TaskPriority.Medium)
  val task2: Task = Task("Second task", LocalDate.of(2024, 2, 10), TaskPriority.High)
  val task3: Task = Task("Third task", LocalDate.of(2024, 2, 20), TaskPriority.Low)
  val task4: Task = Task("Fourth task", LocalDate.of(2024, 2, 25), TaskPriority.High)

  luisTasks = luisTasks.addTask(task1).addTask(task2).addTask(task3).addTask(task4)

  println(luisTasks)
  println()
  println(luisTasks.sortTasks("priority"))
  println()
  println(luisTasks.sortTasks("dueDate"))

  luisTasks = luisTasks.activateTask(task1.getId)
  println()
  println(luisTasks)

  luisTasks = luisTasks.completeTask(task1.getId)
  println()
  println(luisTasks)

  luisTasks = luisTasks.deleteTask(task1.getId)
  println()
  println(luisTasks)
}
