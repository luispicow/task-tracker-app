package tasktrackerapp

import java.time.LocalDate
import java.util.UUID

/**
 * Unit tests for the Task class.
 */
class TestTask extends munit.FunSuite:
  /**
   * Test that the ID of a Task is correctly retrieved.
   */
  test("Task - Get ID"):
    val expectedId: UUID = UUID.randomUUID()
    val actual = new Task(description = "test", dueDate = LocalDate.of(2024, 2, 4), id = expectedId)
    assertEquals(actual.getId, expectedId)

  /**
   * Test that the default status of a Task is New.
   */
  test("Task - Default Status is New"):
    val expectedStatus: TaskStatus = TaskStatus.New
    val actual = new Task("test", LocalDate.of(2024, 2, 4))
    assertEquals(actual.status, expectedStatus)

  /**
   * Test that the default priority of a Task is Low.
   */
  test("Task - Default Priority is Low"):
    val expectedPriority: TaskPriority.TaskPriority = TaskPriority.Low
    val actual = new Task("test", LocalDate.of(2024, 2, 4))
    assertEquals(actual.priority, expectedPriority)

  /**
   * Test that the status of a Task can be changed to Active.
   */
  test("Task - Change Status to Active"):
    val expectedStatus: TaskStatus = TaskStatus.Active
    val actual = new Task("test", LocalDate.of(2024, 2, 4)).changeStatus(expectedStatus)
    assertEquals(actual.status, expectedStatus)

  /**
   * Test that the priority of a Task can be changed to High.
   */
  test("Task - Change Priority to High"):
    val expectedPriority: TaskPriority.TaskPriority = TaskPriority.High
    val actual = new Task("test", LocalDate.of(2024, 2, 4)).changePriority(expectedPriority)
    assertEquals(actual.priority, expectedPriority)