package ru.axas.avatars.presentation.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ru.axas.avatars.R
import ru.axas.avatars.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {
    val binding by lazy { DataBindingUtil.setContentView<ActivitySplashBinding>(this,
            R.layout.activity_splash
    ) }
    override val progressBar  by lazy { binding.progressBar }
    override val splashScreen  by lazy { binding.splashScreen }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
        baseActivityInit()

        val str="Lorem ipsum dolor sit amet \n\nconsectetur adipiscing elit. Gravida consectetur ultricies sit dictum."

    }
}