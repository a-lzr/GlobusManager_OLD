package by.tms.globusmanager.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.tms.globusmanager.R
import by.tms.globusmanager.MainApplication

const val ID_MENU_INSTRUCTIONS = 1
const val ID_MENU_TOOLS = 2
const val ID_MENU_SETTINGS_PERSONAL = 3
const val ID_MENU_SETTINGS = 4
const val ID_MENU_INFO = 5

data class MenuItem(val id: Int, val name: String, val image: Int)

class MenuViewModel : ViewModel() {

    val list = MutableLiveData<ArrayList<MenuItem>>().apply {
        val context = MainApplication.appContext
        value = arrayListOf(
            MenuItem(
                ID_MENU_INSTRUCTIONS,
                context.getString(R.string.menu_instructions),
                R.drawable.ic_library_books_black_48dp
            ),
            MenuItem(
                ID_MENU_TOOLS,
                context.getString(R.string.menu_tools),
                R.drawable.ic_build_black_48dp
            ),
            MenuItem(
                ID_MENU_SETTINGS_PERSONAL,
                context.getString(R.string.menu_settings_personal),
                R.drawable.ic_phonelink_setup_black_48dp
            ),
            MenuItem(
                ID_MENU_SETTINGS,
                context.getString(R.string.menu_settings),
                R.drawable.ic_settings_black_48dp
            ),
            MenuItem(
                ID_MENU_INFO,
                context.getString(R.string.menu_info),
                R.drawable.ic_info_outline_black_48dp
            )
        )
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}