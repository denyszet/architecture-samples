package com.frankvu.screenRobot

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import org.hamcrest.Matcher

open class BaseScreenRobot {
    fun typeText(viewNatcher: Matcher<View>, text: String) {
        Espresso.onView(viewNatcher).perform(ViewActions.replaceText(text))
    }

    fun tapOn(viewNatcher: Matcher<View>) {
        Espresso.onView(viewNatcher).perform(ViewActions.click())
    }
}