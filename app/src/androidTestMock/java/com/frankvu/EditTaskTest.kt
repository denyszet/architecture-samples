package com.frankvu

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity
import com.frankvu.screenRobot.MainScreenRobot
import com.frankvu.screenRobot.NewTaskScreenRobot
import com.frankvu.screenRobot.TaskDetailScreenRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EditTaskTest {
    @Rule
    @JvmField
    var mActivity = ActivityScenarioRule(TasksActivity::class.java)

    @Test
    fun verifyTaskIsEditedSuccessfully() {
        val taskTitle = "Doing Proton assignment"
        val taskDescription = "Implement automation test for ToDo app"
        val updatedTaskTitle = "Refactor code"
        val updatedTaskDescription = "Refactor code for Proton assignment"

        MainScreenRobot().viewNewTaskScreen()
        NewTaskScreenRobot().createNewTask(taskTitle, taskDescription)
        MainScreenRobot().verifyTaskTitle(taskTitle)
        MainScreenRobot().viewTaskDetails(taskTitle)
        TaskDetailScreenRobot().editTask(updatedTaskTitle, updatedTaskDescription)
        MainScreenRobot().verifyTaskTitle(updatedTaskTitle)
        MainScreenRobot().viewTaskDetails(updatedTaskTitle)
        TaskDetailScreenRobot().verifyTaskDetail(updatedTaskTitle, updatedTaskDescription)
    }
}