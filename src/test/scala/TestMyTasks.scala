package tasktrackerapp

import java.time.LocalDate

/**
 * Unit tests for the MyTasks class.
 */
class TestMyTasks extends munit.FunSuite:
  /**
   * Test that a new instance of MyTasks has an empty list of tasks by default.
   */
  test("MyTasks - Creating new instance has empty list of tasks by default"):
    val expected: List[Task] = List()
    val actual: MyTasks = MyTasks("Tester")
    assertEquals(expected, actual.tasks)

  /**
   * Test that a task can be added to the list of tasks in MyTasks.
   */
  test("MyTasks - Adding a task to the list of tasks"):
    val expectedTask: Task = Task("Test Task", LocalDate.of(2024, 2, 4))
    val expected: List[Task] = List(expectedTask)
    val actual: MyTasks = MyTasks("Tester").addTask(expectedTask)
    assertEquals(actual.tasks, expected)

  /**
   * Test that a task can be activated in MyTasks.
   */
  test("MyTasks - Activate a task"):
    val task1: Task = Task("Test Task 1", LocalDate.of(2024, 2, 4))
    val task2: Task = Task("Test Task 2", LocalDate.of(2024, 2, 4))
    val expected: List[Task] = List(task2, task1.changeStatus(TaskStatus.Active))
    val actual: MyTasks = MyTasks("Tester").addTask(task1).addTask(task2).activateTask(task1.getId)
    assertEquals(actual.tasks.map(t => s"${t.toString}").mkString(","), expected.map(t => s"${t.toString}").mkString(","))

  /**
   * Test that a task can be completed in MyTasks.
   */
  test("MyTasks - Complete a task"):
    val task1: Task = Task("Test Task 1", LocalDate.of(2024, 2, 4))
    val task2: Task = Task("Test Task 2", LocalDate.of(2024, 2, 4))
    val expected: List[Task] = List(task2.changeStatus(TaskStatus.Completed), task1)
    val actual: MyTasks = MyTasks("Tester").addTask(task1).addTask(task2).completeTask(task2.getId)
    assertEquals(actual.tasks.map(t => s"${t.toString}").mkString(","), expected.map(t => s"${t.toString}").mkString(","))

  /**
   * Test that a task can be deleted from MyTasks.
   */
  test("MyTasks - Delete a task"):
    val task1: Task = Task("Test Task 1", LocalDate.of(2024, 2, 4))
    val task2: Task = Task("Test Task 2", LocalDate.of(2024, 2, 4))
    val expected: List[Task] = List(task2)
    val actual: MyTasks = MyTasks("Tester").addTask(task1).addTask(task2).deleteTask(task1.getId)
    assertEquals(actual.tasks, expected)

  /**
   * Test that the priority of a task can be changed in MyTasks.
   */
  test("MyTasks - Change task priority"):
    val task1: Task = Task("Test Task 1", LocalDate.of(2024, 2, 4))
    val task2: Task = Task("Test Task 2", LocalDate.of(2024, 2, 4))
    val expected: List[Task] = List(task2.changePriority(TaskPriority.High), task1)
    val actual: MyTasks = MyTasks("Tester").addTask(task1).addTask(task2).changeTaskPriority(task2.getId, TaskPriority.High)
    assertEquals(actual.tasks.map(t => s"${t.toString}").mkString(","), expected.map(t => s"${t.toString}").mkString(","))

  /**
   * Test that tasks can be sorted by priority in MyTasks.
   */
  test("MyTasks - Sort tasks by priority"):
    val task1: Task = Task("Test Task 1", LocalDate.of(2024, 2, 4), TaskPriority.Low)
    val task2: Task = Task("Test Task 2", LocalDate.of(2024, 2, 4), TaskPriority.Medium)
    val task3: Task = Task("Test Task 3", LocalDate.of(2024, 2, 4), TaskPriority.High)
    val expected: List[Task] = List(task3, task2, task1)
    val actual: MyTasks = MyTasks("Tester").addTask(task1).addTask(task2).addTask(task3).sortTasks("priority")
    assertEquals(actual.tasks.map(t => s"${t.toString}").mkString(","), expected.map(t => s"${t.toString}").mkString(","))

  /**
   * Test that tasks can be sorted by due date in MyTasks.
   */
  test("MyTasks - Sort tasks by due date"):
    val task1: Task = Task("Test Task 1", LocalDate.of(2021, 1, 5))
    val task2: Task = Task("Test Task 2", LocalDate.of(2022, 10, 10))
    val task3: Task = Task("Test Task 3", LocalDate.of(2022, 3, 12))
    val expected: List[Task] = List(task1, task3, task2)
    val actual: MyTasks = MyTasks("Tester").addTask(task3).addTask(task2).addTask(task1).sortTasks("dueDate")
    assertEquals(actual.tasks.map(t => s"${t.toString}").mkString(","), expected.map(t => s"${t.toString}").mkString(","))