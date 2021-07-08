package ru.axas.avatars.presentation.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import ru.axas.avatars.R
import ru.axas.avatars.databinding.ActivityEntranceBinding
import ru.axas.avatars.helpers_managers.ToastyManager
import javax.inject.Inject

class EntranceActivity : BaseActivity() {
    val binding by lazy { DataBindingUtil.setContentView<ActivityEntranceBinding>(this,
        R.layout.activity_entrance
    ) }
    override val progressBar  by lazy { binding.progressBar }
    override val splashScreen  by lazy { binding.splashScreen }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
        baseActivityInit()

        toasyManger.toasty("toasty! ☺ ")

    }
}