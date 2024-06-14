package com.example.modelingrobots

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.modelingrobots.databases.RobotsDatabase
import com.example.modelingrobots.databinding.ActivityMainBinding
import com.example.modelingrobots.viewmodels.InsicisionLinkViewModel
import com.example.modelingrobots.viewmodels.MotorsViewModel
import com.example.modelingrobots.viewmodels.ParametersRobotsViewModel
import com.example.modelingrobots.viewmodels.RegulatorsViewModel
import com.example.modelingrobots.viewmodels.TrajectoryParametersViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val parametersRobotViewModel: ParametersRobotsViewModel by viewModels()
    private val insicisionLinkViewModel: InsicisionLinkViewModel by viewModels()
    private val regulatorsViewModel: RegulatorsViewModel by viewModels()
    private val motorsViewModel: MotorsViewModel by viewModels()
    private val trajectoryParametersViewModel: TrajectoryParametersViewModel by viewModels()
    private var chooseConfigurationName: String = "my_robots"
    final val DEF_SET = "DEF_SET"
    final val INITIAL_STATE = "INITIAL_STATE"
    val database by lazy {
        Room.databaseBuilder(
            this,
            RobotsDatabase::class.java, "robotsdb.db"
        ).fallbackToDestructiveMigration().build()
    }

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
        /*insertData()
        if (getInitialState()) {
            setDefaultData()
            insertData()
            setInitialState(false)
        }
        else {
            getData()
        }*/
        setDefaultData()
    }

    override fun onDestroy() {
        super.onDestroy()
        /*updateData()
        setInitialState(false)
        Toast.makeText(applicationContext, "this is anther state", Toast.LENGTH_SHORT).show()*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.graphicsFragment -> NavigationUI.onNavDestinationSelected(item, navController = findNavController(R.id.nav_host_fragment_content_main))
            R.id.clear_data -> {
                setDefaultData()
                true
            }
            /*R.id.open_file -> {
                val array = getNames()
                showOpenConfigurationDialog(array)
                true
            }*/
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
    private fun setInitialState(state: Boolean) {
        val prefs: SharedPreferences = getSharedPreferences(DEF_SET, Context.MODE_PRIVATE)
        with(prefs.edit()) {
            putBoolean(INITIAL_STATE, state)
        }.apply()
    }
    private fun getInitialState() = getSharedPreferences(DEF_SET, Context.MODE_PRIVATE).getBoolean(INITIAL_STATE, true)

    private fun setDefaultData() {
        parametersRobotViewModel.setDefaultValue()
        insicisionLinkViewModel.setDefaultValue()
        motorsViewModel.setDefaultValue()
        regulatorsViewModel.setDefaultValue()
        trajectoryParametersViewModel.setDefaultValue()
    }
    private fun insertData() {
        database.robotsDao.let {
            parametersRobotViewModel.insertViewDataInDatabase(it, chooseConfigurationName!!)
            insicisionLinkViewModel.insertViewDataInDatabase(it, chooseConfigurationName!!)
            regulatorsViewModel.insertViewDataInDatabase(it, chooseConfigurationName!!)
            motorsViewModel.insertViewDataInDatabase(it, chooseConfigurationName!!)
            trajectoryParametersViewModel.insertViewDataInDatabase(it, chooseConfigurationName!!)
        }
    }
    private fun updateData() {
        database.robotsDao.let {
            parametersRobotViewModel.updateDatabaseFromViewModel(it, chooseConfigurationName!!)
            insicisionLinkViewModel.updateDatabaseFromViewModel(it, chooseConfigurationName!!)
            regulatorsViewModel.updateDatabaseFromViewModel(it, chooseConfigurationName!!)
            motorsViewModel.updateDatabaseFromViewModel(it, chooseConfigurationName!!)
            trajectoryParametersViewModel.updateDatabaseFromViewModel(it, chooseConfigurationName!!)
        }
    }
    private fun getData() {
        database.robotsDao.let {
            parametersRobotViewModel.updateViewModelFromDatabase(it, chooseConfigurationName!!)
            insicisionLinkViewModel.updateViewModelFromDatabase(it, chooseConfigurationName!!)
            regulatorsViewModel.updateViewModelFromDatabase(it, chooseConfigurationName!!)
            motorsViewModel.updateViewModelFromDatabase(it, chooseConfigurationName!!)
            trajectoryParametersViewModel.updateViewModelFromDatabase(it, chooseConfigurationName!!)
        }
    }
    /*fun getNames():  Array<String>{
        return database.robotsDao.getNamesConfigurationsRobots().asLiveData().value!!
    }*/

    /*inner class SaveConfigurationDialog(val namesFiles: Array<String>): DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {
                val builder = AlertDialog.Builder(it)
                val inflater = requireActivity().layoutInflater
                val bindDialog = inflater.inflate(R.layout.save_configuration_fragment, null)
                val fileName = bindDialog.findViewById<TextInputEditText>(R.id.et_savefile)
                val field = bindDialog.findViewById<TextInputLayout>(R.id.til_savefile)
                fileName.setOnFocusChangeListener { v, hasFocus ->
                    if(!hasFocus) {
                        field.helperText = when {
                            fileName.text.toString().isEmpty() -> "Пустая строка"
                            fileName.text.toString() in namesFiles -> "Имя файла уже существует"
                            else -> ""
                        }
                    }
                }
                builder.setTitle("Сохранение конфигурации")
                    .setView(bindDialog)
                    .setPositiveButton("Сохранить", DialogInterface.OnClickListener { dialog, which ->
                        dialog.cancel()})/*
                        if ("fileName.text.toString()" != "") {
                            chooseConfigurationName = "fileName.text.toString()"
                            if (chooseConfigurationName in namesFiles) {
                                AlertDialog.Builder(requireContext())
                                    .setTitle("Перезапись файла")
                                    .setMessage("Вы увверены, что хотите перезаписать файл?")
                                    .setPositiveButton("Да", DialogInterface.OnClickListener { dialog, which ->
                                        updateData()
                                    })
                                    .setNegativeButton("Нет", DialogInterface.OnClickListener { dialog, which ->  dialog.cancel()})
                                    .create().show()
                            }
                            else {
                                insertData()
                            }
                        }
                    })*/
                    .setNegativeButton("Отмена", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }
    }
    private fun showSaveConfigurationDialog(array: Array<String>) {
        SaveConfigurationDialog(array).show(supportFragmentManager, "Save Configuration")
    }

    inner class OpenConfigurationDialog(val namesFiles: Array<String>): DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {
                val builder = AlertDialog.Builder(it)
                val inflater = requireActivity().layoutInflater
                builder.setTitle("Открыть конфигурацию")
                    .setItems(namesFiles) { dialog, which ->
                        chooseConfigurationName = namesFiles[which]
                        getData()
                    }
                    .setNegativeButton("Отмена", DialogInterface.OnClickListener { dialog, which -> getDialog()!!.cancel() })
                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }
    }
    private fun showOpenConfigurationDialog(array: Array<String>) {
        OpenConfigurationDialog(array).show(supportFragmentManager, "Open Configuration")
    }*/

}

