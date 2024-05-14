package com.frankvu.screenRobot

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.example.android.architecture.blueprints.todoapp.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher

class TaskDetailScreenRobot : BaseScreenRobot() {

    fun deleteTask(): TaskDetailScreenRobot {
        tapOn(TASK_DETAIL_COMPLETE_CHECKBOX)
        tapOn(DELETE_TASK_BUTTON)

        return this
    }

    fun editTask(taskTitle: String, taskDescription: String): TaskDetailScreenRobot {
        tapOn(TASK_DETAIL_COMPLETE_CHECKBOX)
        tapOn(EDIT_TASK_BUTTON)
        typeText(EDIT_TASK_TITLE_TEXT, taskTitle)
        typeText(EDIT_TASK_DESCRIPTION_TEXT, taskDescription)
        tapOn(SAVE_TASK_BUTTON)

        return this
    }

    fun verifyTaskDetail(taskTitle: String, taskDescription: String): TaskDetailScreenRobot {
        onView(TaskDetailScreenRobot.TASK_TITLE_TEXT).check(matches(withText(taskTitle)))
        onView(TaskDetailScreenRobot.TASK_DESCRIPTION_TEXT).check(matches(withText(taskDescription)))

        return this
    }

    companion object {
        val TASK_TITLE_TEXT: Matcher<View> = withId(R.id.task_detail_title_text)
        val TASK_DESCRIPTION_TEXT: Matcher<View> = withId(R.id.task_detail_description_text)
        val TASK_DETAIL_COMPLETE_CHECKBOX: Matcher<View> = withId(R.id.task_detail_complete_checkbox)
        val DELETE_TASK_BUTTON: Matcher<View> = withId(R.id.menu_delete)
        val EDIT_TASK_BUTTON: Matcher<View> = withId(R.id.edit_task_fab)
        val SAVE_TASK_BUTTON: Matcher<View> = withId(R.id.save_task_fab)
        val EDIT_TASK_TITLE_TEXT: Matcher<View> = withId(R.id.add_task_title_edit_text)
        val EDIT_TASK_DESCRIPTION_TEXT: Matcher<View> = withId(R.id.add_task_description_edit_text)
    }
}