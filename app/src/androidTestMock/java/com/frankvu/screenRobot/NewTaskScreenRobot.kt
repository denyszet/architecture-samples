package com.frankvu.screenRobot

import android.view.View
import com.example.android.architecture.blueprints.todoapp.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher

class NewTaskScreenRobot : BaseScreenRobot() {

    fun createNewTask(taskTitle: String, taskDescription: String): NewTaskScreenRobot {
        typeText(TASK_TITLE, taskTitle)
        typeText(TASK_DESCRIPTION, taskDescription)
        tapOn(SAVE_TASK_BUTTON)

        return this
    }

    companion object {
        val TASK_TITLE: Matcher<View> = withId(R.id.add_task_title_edit_text)
        val TASK_DESCRIPTION: Matcher<View> = withId(R.id.add_task_description_edit_text)
        val SAVE_TASK_BUTTON: Matcher<View> = withId(R.id.save_task_fab)
    }
}