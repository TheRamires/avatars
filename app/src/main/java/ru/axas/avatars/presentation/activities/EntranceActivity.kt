package ru.axas.avatars.presentation.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.axas.avatars.R
import ru.axas.avatars.databinding.ActivityEntranceBinding

class EntranceActivity : BaseActivity() {
    val binding by lazy { DataBindingUtil.setContentView<ActivityEntranceBinding>(
        this,
        R.layout.activity_entrance
    )}

    val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override val progressBar  by lazy { binding.progressBar }
    override val splashScreen  by lazy { binding.splashScreen }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
        baseActivityInit()

        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = getString(R.string.regist_text_registration)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                println("back")
                navController.popBackStack()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}