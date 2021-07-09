package ru.axas.avatars.presentation.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.axas.avatars.R
import ru.axas.avatars.databinding.ActivityEntranceBinding

class EntranceActivity : BaseActivity() {
    val binding by lazy { DataBindingUtil.setContentView<ActivityEntranceBinding>(this,
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

        val backIcon= AppCompatResources.getDrawable(this,R.drawable.back_stack)
        val toolbar = binding.toolbar
        toolbar.navigationIcon = backIcon
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title=resources.getString(R.string.registration)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{ navController.popBackStack()}
        }
        return super.onOptionsItemSelected(item)
    }
}