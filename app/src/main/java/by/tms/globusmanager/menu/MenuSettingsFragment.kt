package by.tms.globusmanager.menu

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import by.tms.globusmanager.R

class MenuSettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.menu_settings, rootKey)
    }
}