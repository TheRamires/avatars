package ru.axas.avatars.presentation.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.axas.avatars.R
import ru.axas.avatars.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this,
        R.layout.activity_main
    ) }
    override val progressBar  by lazy { binding.progressBar }
    override val splashScreen  by lazy { binding.splashScreen }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment, R.id.findFragment, R.id.chatFragment, R.id.findFragment,R.id.profileFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}