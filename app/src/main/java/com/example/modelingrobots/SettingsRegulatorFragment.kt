package com.example.modelingrobots

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class SettingsRegulatorFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}