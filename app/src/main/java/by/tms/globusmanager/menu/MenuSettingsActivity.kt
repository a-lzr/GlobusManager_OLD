package by.tms.globusmanager.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.tms.globusmanager.R

class MenuSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_settings)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings_fragment, MenuSettingsFragment())
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
}
