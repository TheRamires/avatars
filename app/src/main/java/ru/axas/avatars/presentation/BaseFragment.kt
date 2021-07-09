package ru.axas.avatars.presentation

import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.axas.avatars.presentation.activities.BaseActivity
import ru.axas.avatars.presentation.activities.base

abstract class BaseFragment: Fragment() {
    abstract val TAG_LOG : String
    val supportActionBar by lazy { (activity as AppCompatActivity).supportActionBar}

    fun showProgressBar() = base { progressBarStatus(View.VISIBLE) }

    fun hideProgressBar() = base { progressBarStatus(View.GONE) }


    fun showSplashScreen() = base { splashScreenStatus(View.VISIBLE) }

    fun hideSplashScreen() = base { splashScreenStatus(View.GONE) }


    inline fun base(block: BaseActivity.() -> Unit) {
        activity.base (block)
    }
}