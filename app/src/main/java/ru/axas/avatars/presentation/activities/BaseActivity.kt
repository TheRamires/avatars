package ru.axas.avatars.presentation.activities
import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.AndroidEntryPoint
import ru.axas.avatars.helpers_managers.ToastyManager
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    abstract val progressBar: ProgressBar
    abstract val splashScreen: FrameLayout
    @Inject
    lateinit var toasyManger : ToastyManager

    fun baseActivityInit(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    fun showProgressBar() = progressBarStatus(View.VISIBLE)

    fun hideProgressBar() = progressBarStatus(View.GONE)

    fun progressBarStatus(viewStatus: Int) {
        progressBar.visibility = viewStatus
    }


    fun showSplashScreen() = splashScreenStatus(View.VISIBLE)

    fun hideSplashScreen() = splashScreenStatus(View.GONE)

    fun splashScreenStatus(viewStatus: Int) {
        progressBar.visibility = viewStatus
    }
}

inline fun Activity?.base(block: BaseActivity.() -> Unit) {
    (this as? BaseActivity)?.let(block)
}