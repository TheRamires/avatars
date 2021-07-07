package ru.axas.avatars.presentation.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ru.axas.avatars.R
import ru.axas.avatars.databinding.ActivityEntranceBinding

class EntranceActivity : BaseActivity() {
    val binding by lazy { DataBindingUtil.setContentView<ActivityEntranceBinding>(this,
        R.layout.activity_entrance
    ) }
    override val progressBar  by lazy { binding.progressBar }
    override val splashScreen  by lazy { binding.splashScreen }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }
}