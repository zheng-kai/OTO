package com.app.oto.otoapplication.scan.car_user

import android.support.v4.content.res.ResourcesCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cn.edu.twt.retrox.recyclerviewdsl.Item
import cn.edu.twt.retrox.recyclerviewdsl.ItemController
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.CommonContext
import kotlinx.android.synthetic.main.rec_item_pick_car.view.*
import org.jetbrains.anko.layoutInflater

class ScanCarRecItem(val position:Int,val boxId:String) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            item as ScanCarRecItem
            holder as MViewHolder
            val titleStr = "包裹${item.position}"
            val boxIdStr = "智能环保箱编号：${item.boxId}"
            holder.title.text = titleStr
            holder.boxId.text = boxIdStr
            holder.btn.setOnClickListener {
                holder.btn.background = ResourcesCompat.getDrawable(CommonContext.application.resources,R.drawable.button_background_orange,null)
                holder.btn.text = "正在出库"
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val view = parent.context.layoutInflater.inflate(R.layout.rec_item_pick_car, parent, false)
            val title = view.tv_car_pick_title
            val boxId = view.tv_car_pick_box_id
            val btn = view.btn_car_pick
            return MViewHolder(view,title,boxId,btn)
        }

    }

    private class MViewHolder(itemView: View, val title: TextView, val boxId: TextView, val btn: Button) :
        RecyclerView.ViewHolder(itemView)

    override val controller: ItemController
        get() = Controller
}
fun MutableList<Item>.add(position:Int,boxId:String) = add(ScanCarRecItem(position,boxId))