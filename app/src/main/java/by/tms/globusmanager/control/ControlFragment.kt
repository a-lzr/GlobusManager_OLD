package by.tms.globusmanager.control

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.tms.globusmanager.R

class ControlFragment : Fragment() {

    private lateinit var controlViewModel: ControlViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        controlViewModel = ViewModelProvider(this).get(ControlViewModel::class.java)
//        controlViewModel =
//                ViewModelProviders.of(this).get(ControlViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_control, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        controlViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
