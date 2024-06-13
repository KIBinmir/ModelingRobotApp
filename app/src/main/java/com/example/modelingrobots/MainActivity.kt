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
import androidx.room.Room
import com.example.modelingrobots.databases.RobotsDatabase
import com.example.modelingrobots.databinding.ActivityMainBinding
import com.example.modelingrobots.robots.linksSections.Materials
import com.example.modelingrobots.viewmodels.InsicisionLinkViewModel
import com.example.modelingrobots.viewmodels.MotorsViewModel
import com.example.modelingrobots.viewmodels.ParametersRobotsViewModel
import com.example.modelingrobots.viewmodels.RegulatorsViewModel
import com.example.modelingrobots.viewmodels.TrajectoryParametersViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val parametersRobotViewModel: ParametersRobotsViewModel by viewModels()
    private val insicisionLinkViewModel: InsicisionLinkViewModel by viewModels()
    private val regulatorsViewModel: RegulatorsViewModel by viewModels()
    private val motorsViewModel: MotorsViewModel by viewModels()
    private val trajectoryParametersViewModel: TrajectoryParametersViewModel by viewModels()
    private var chooseConfigurationName: String? = "My_robots_config"
    val database by lazy {
        Room.databaseBuilder(
            this,
            RobotsDatabase::class.java, "robotsdb.db"
        ).build()
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
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.graphicsFragment -> NavigationUI.onNavDestinationSelected(item, navController = findNavController(R.id.nav_host_fragment_content_main))
            R.id.save_config -> {

                /*if (chooseConfigurationName == null) {
                    //val array = getNames()
                    val array = arrayOf("fydfuy")
                    showSaveConfigurationDialog(array)
                }
                else {
                    Thread{
                        updateData()
                    }.start()
                }*/
                true
            }
            R.id.clear_config -> {
                /*val array = getNames()
                showSaveConfigurationDialog(array)*/
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
    /*inner class SaveConfigurationDialog(val namesFiles: Array<String>): DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {
                val builder = AlertDialog.Builder(it)
                /*val inflater = requireActivity().layoutInflater
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
                }*/
                builder.setTitle("Сохранение конфигурации")
                    //.setView(bindDialog)
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
    private fun insertData() {
        Thread {
            database.robotsDao.apply {
                insertRobotConfiguration(parametersRobotViewModel.getData(chooseConfigurationName!!))
                insertMotors(motorsViewModel.getData(chooseConfigurationName!!))
                insertRegulators(regulatorsViewModel.getData(chooseConfigurationName!!))
                insertIncisionLink(insicisionLinkViewModel.getData(chooseConfigurationName!!))
                insertTrajectory(trajectoryParametersViewModel.getData(chooseConfigurationName!!))
            }
        }.start()
    }
    private fun updateData() {
        Thread {
            database.robotsDao.apply {
                updateRobotConfiguration(parametersRobotViewModel.getData(chooseConfigurationName!!))
                updateMotors(motorsViewModel.getData(chooseConfigurationName!!))
                updateRegulators(regulatorsViewModel.getData(chooseConfigurationName!!))
                updateIncisionLink(insicisionLinkViewModel.getData(chooseConfigurationName!!))
                updateTrajectory(trajectoryParametersViewModel.getData(chooseConfigurationName!!))
            }
        }.start()
    }
    /*fun getNames():  Array<String>{
        return database.robotsDao.getNamesConfigurationsRobots().asLiveData().value!!
    }*/
    private fun getData() {
        GlobalScope.launch {
            val parametersConfiguration = database.robotsDao.getRobotsConfiguration(chooseConfigurationName!!)[0]
            val incisionLink = database.robotsDao.getSectionLink(chooseConfigurationName!!)[0]
            val regulators = database.robotsDao.getRegulators(chooseConfigurationName!!)[0]
            val motors = database.robotsDao.getMotors(chooseConfigurationName!!)[0]
            val trajectory = database.robotsDao.getTrajectory(chooseConfigurationName!!)[0]
            val material = when(incisionLink.material) {
                "Аллюминий" -> Materials.Aluminum
                "Пластмасса" -> Materials.Plastic
                "Сталь" -> Materials.Steel
                else -> Materials.Aluminum
            }
            parametersConfiguration.apply { parametersRobotViewModel.setValues(robot, l1, l2, q1Min, q1Max, q2Min, q2Max) }
            incisionLink.apply { insicisionLinkViewModel.setValues(typeSection, material, param1, param2!!, param3!!) }
            regulators.apply { regulatorsViewModel.setValues(kp1, kd1, ki1, kp2, kd2, ki2) }
            motors.apply {
                motorsViewModel.setValues1(j1, l1, r1, km1, ke1)
                motorsViewModel.setValues2(j2, l2, r2, km2, ke2)
            }
            trajectory.apply { trajectoryParametersViewModel.setValues(typeCoordinates, listOf(ItemTimeTable(t0, p1_t0, p2_t0), ItemTimeTable(t1, p1_t1, p2_t1))) }
            /*parametersRobotViewModel.apply {
                l1.value = parametersConfiguration.l1
                l2.value = parametersConfiguration.l2
                q1min.value = parametersConfiguration.q1Min
                q1max.value = parametersConfiguration.q1Max
                q2min.value = parametersConfiguration.q2Min
                q2max.value = parametersConfiguration.q2Max
                typeRobot.value = parametersConfiguration.robot
            }
            insicisionLinkViewModel.apply {
                typeLink.value = incisionLink.typeSection
                materialLink.value = when(incisionLink.material) {
                    "Аллюминий" -> Materials.Aluminum
                    "Пластмасса" -> Materials.Plastic
                    "Сталь" -> Materials.Steel
                    else -> Materials.Aluminum
                }
                p1.value = incisionLink.param1
                p2.value = incisionLink.param2
                p2.value = incisionLink.param3
            }
            regulatorsViewModel.apply {
                kp1.value = regulators.kp1
                kp2.value = regulators.kp2
                kd1.value = regulators.kd1
                kd2.value = regulators.kd2
                ki1.value = regulators.ki1
                ki2.value = regulators.ki2
            }
            motorsViewModel.apply {
                l1.value = motors.l1
                l2.value = motors.l2
                r1.value = motors.r1
                r2.value = motors.r2
                j1.value = motors.j1
                j2.value = motors.j2
                ke1.value = motors.ke1
                ke2.value = motors.ke2
                km1.value = motors.km1
                km2.value = motors.km2
            }
            trajectoryParametersViewModel.apply {
                typeCoordinates.value = trajectory.typeCoordinates
                timeTable.value = listOf(
                    ItemTimeTable(trajectory.t0, trajectory.p1_t0, trajectory.p2_t0),
                    ItemTimeTable(trajectory.t1, trajectory.p1_t1, trajectory.p2_t1)
                )
            }*/
        }
    }
}

