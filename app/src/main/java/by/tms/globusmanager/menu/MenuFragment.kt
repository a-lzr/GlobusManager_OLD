package by.tms.globusmanager.menu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.tms.globusmanager.R
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    private lateinit var menuViewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val adapter =
//            ArrayAdapter<String>(this, R.layout.item_menu, NamesCollections.instance.names)

//        menuViewModel =
//                ViewModelProviders.of(this).get(MenuViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_menu, container, false)
        context ?: return root

        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

//        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
//        val adapter = context?.let { MenuAdapter(it, menuViewModel.list) }
//        val adapter = MenuAdapter(menuGridView.context, menuViewModel.list)
//        menuGridView.adapter = adapter


//        menuViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        menuViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = MenuAdapter(menuGridView.context, menuViewModel.list)
        menuGridView.adapter = adapter

        menuGridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = menuViewModel.list.value!![position]

                when (item.id) {
//                    ID_MENU_INSTRUCTIONS -> {
//                        val intent = Intent(this, Lesson1Activity::class.java)
//                        startActivity(intent)
//                    }
//                    ID_MENU_TOOLS -> {
//                        val intent = Intent(this, Lesson1Activity::class.java)
//                        startActivity(intent)
//                    }
//                    ID_MENU_SETTINGS_PERSONAL -> {
//                        val intent = Intent(this, Lesson1Activity::class.java)
//                        startActivity(intent)
//                    }
                    ID_MENU_SETTINGS -> {
                        val intent = Intent(activity, MenuSettingsActivity::class.java)
                        startActivity(intent)
//                        http://developer.alexanderklimov.ru/android/preferences_framework.php
//                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
                    ID_MENU_INFO -> {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    }
                    else -> Toast.makeText(view?.context, "Обработчик еще не задан", Toast.LENGTH_SHORT).show()
                }

//                val intent = Intent(view?.context, DetailActivity::class.java)
//                intent.putExtra("NAME", parent?.getItemAtPosition(position).toString())
//                startActivity(intent)
            }

//        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
//        val adapter = context?.let { MenuAdapter(it, menuViewModel.list) }
//        val adapter = MenuAdapter(menuGridView.context, menuViewModel.list)
//        menuGridView.adapter = adapter

//        menuViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
//        val adapter = context?.let { MenuAdapter(it, menuViewModel.list) }
//        val adapter = MenuAdapter(container.context, menuViewModel.list)
//        menuGridView.adapter = adapter
    }
}
