package com.app.oto.otoapplication.scan.nomal_user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.CommonContext
import kotlinx.android.synthetic.main.spinner_item.view.*

class SpinnerAdapter : BaseAdapter() {
    private var data = ArrayList<String>()
    fun setData(data:List<String>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View =
            convertView ?: LayoutInflater.from(CommonContext.application).inflate(R.layout.spinner_item, null)
        val text = view.tv_spinner
        text.text = data[position]
        return view
    }

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = data.size

}