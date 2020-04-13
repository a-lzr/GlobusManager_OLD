package by.tms.globusmanager.menu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.lifecycle.MutableLiveData
import by.tms.globusmanager.R
import kotlinx.android.synthetic.main.item_menu.view.*

class MenuAdapter(
    private val context: Context,
    private val list: MutableLiveData<ArrayList<MenuItem>>
) : BaseAdapter() {
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = list.value!![position]
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.item_menu, null)
        itemView.itemImage.setImageResource(item.image)
        itemView.itemName.text = item.name
        return itemView
    }

    override fun getItem(position: Int): Any {
        return list.value!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.value!!.size
    }
}