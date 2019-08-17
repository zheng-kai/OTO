package com.app.oto.otoapplication.scan.nomaluser

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.CommonContext
import kotlinx.android.synthetic.main.gridview_item.view.*
import kotlinx.android.synthetic.main.scan_result_normal.*
import org.jetbrains.anko.layoutInflater

class GridViewAdapter :BaseAdapter(){
    val dataList = ArrayList<String>(listOf("A","B","C","D","E"))
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder:GViewHolder?
        if(convertView == null){
            view = LayoutInflater.from(CommonContext.application).inflate(R.layout.gridview_item,parent,false)
            viewHolder = GViewHolder(view.tv_grid_item)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as GViewHolder
        }
        viewHolder.textView.text = dataList[position]
        return view
    }

    override fun getItem(position: Int): Any = dataList[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = dataList.size
    private class GViewHolder(var textView: TextView)

}