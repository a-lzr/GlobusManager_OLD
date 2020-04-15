package by.tms.globusmanager.menu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import by.tms.globusmanager.MainApplication
import by.tms.globusmanager.R

class MenuSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_settings)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings_fragment, SettingsFragment())
            .commit()

        supportActionBar?.let {
            it.title = getString(R.string.menu_settings)
            it.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.menu_settings_preferences, rootKey)

            val themePreference =
                findPreference<ListPreference>(getString(R.string.menu_settings_theme_code))

            if (themePreference != null) {
                themePreference.onPreferenceChangeListener =
                    Preference.OnPreferenceChangeListener { _, newValue ->
                        MenuSettingsHelper.applyTheme(
                            MainApplication.appContext,
                            newValue.toString()
                        )

                        val name =
                            resources.getStringArray(R.array.menu_settings_theme_names)[resources.getStringArray(
                                R.array.menu_settings_theme_codes
                            ).indexOf(newValue.toString())]

                        Toast.makeText(
                            context,
                            "${getString(R.string.menu_settings_theme_set)} $name",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }
            }
        }
    }
}