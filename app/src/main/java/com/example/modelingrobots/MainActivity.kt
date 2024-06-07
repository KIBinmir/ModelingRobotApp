package com.example.modelingrobots

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.modelingrobots.databinding.ActivityMainBinding
import com.example.modelingrobots.viewmodels.InsicisionLinkViewModel
import com.example.modelingrobots.viewmodels.MotorsViewModel
import com.example.modelingrobots.viewmodels.ParametersRobotsViewModel
import com.example.modelingrobots.viewmodels.RegulatorsViewModel
import com.example.modelingrobots.viewmodels.TrajectoryParametersViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val parametersRobotViewModel: ParametersRobotsViewModel by viewModels()
    private val insicisionLinkViewModel: InsicisionLinkViewModel by viewModels()
    private val regulatorsViewModel: RegulatorsViewModel by viewModels()
    private val motorsViewModel: MotorsViewModel by viewModels()
    private val trajectoryParametersViewModel: TrajectoryParametersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            .setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.graphicsFragment -> NavigationUI.onNavDestinationSelected(item, navController = findNavController(R.id.nav_host_fragment_content_main))
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

}