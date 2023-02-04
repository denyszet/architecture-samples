package com.frankvu.screenRobot

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import com.example.android.architecture.blueprints.todoapp.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher

class MainScreenRobot : BaseScreenRobot() {

    fun viewNewTaskScreen(): MainScreenRobot {
        tapOn(ADD_TASK_BUTTON)

        return this
    }

    fun verifyTaskTitle(taskTitle: String): MainScreenRobot {
        onView(withText(taskTitle)).check(matches(withText(taskTitle)))
        return this
    }

    fun verifyTaskListIsEmpty(): MainScreenRobot {
        onView(MainScreenRobot.NO_TASK_TEXT).check(matches(withText("You have no tasks!")))

        return this
    }

    fun viewTaskDetails(taskTitle: String): MainScreenRobot {
        onView(withText(taskTitle)).perform(click())
        return this
    }

    companion object {
        val ADD_TASK_BUTTON: Matcher<View> = withId(R.id.add_task_fab)
        val NO_TASK_TEXT: Matcher<View> = withId(R.id.no_tasks_text)
    }
}