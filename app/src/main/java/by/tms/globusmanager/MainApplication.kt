package by.tms.globusmanager

import android.app.Application
import android.content.Context
import by.tms.globusmanager.menu.MenuSettingsHelper

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        MenuSettingsHelper.initThemeSettings(appContext)
    }

    companion object {
        lateinit var appContext: Context
    }
}