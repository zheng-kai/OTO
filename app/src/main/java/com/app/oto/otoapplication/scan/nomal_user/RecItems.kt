package com.app.oto.otoapplication.scan.nomal_user

import android.graphics.Color
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cn.edu.twt.retrox.recyclerviewdsl.Item
import cn.edu.twt.retrox.recyclerviewdsl.ItemController
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.CommonContext
import kotlinx.android.synthetic.main.rec_item_pick_normal.view.*
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.textColor

class NormalPickItem(
    val position: Int,
    val boxId: String,
    val date: String,
    val name: String,
    val status: String,
    val content: String
) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            item as NormalPickItem
            holder as MViewHolder
            item.apply {
                val titleStr = "包裹$position"
                val idStr = "智能环保箱编号：$boxId"
                val dateStr = "到达时间内：$date"
                val nameStr = "寄件者：$name"
                val statusStr = status
                val contentStr = "包裹内容：$content"
                holder.apply {
                    title.text = titleStr
                    boxId.text = idStr
                    date.text = dateStr
                    userName.text = nameStr
                    payStatus.text = statusStr
                    content.text = contentStr
                    if (statusStr == "未付款") {
                        payStatus.textColor = Color.parseColor("#D73232")
                        btn.background =
                            ResourcesCompat.getDrawable(CommonContext.application.resources, R.mipmap.big_dot_red, null)
                        btn.text = "付款"
                    } else if (statusStr == "已付款") {
                        payStatus.textColor = Color.parseColor("#1EB81E")
                        btn.background = ResourcesCompat.getDrawable(
                            CommonContext.application.resources,
                            R.mipmap.big_dot_green,
                            null
                        )
                        btn.text = "取件"
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val view = parent.context.layoutInflater.inflate(R.layout.rec_item_pick_normal, parent, false)
            val title = view.tv_normal_pick_title
            val boxId = view.tv_normal_pick_box_id
            val date = view.tv_normal_pick_date
            val userName = view.tv_normal_pick_name
            val payStatus = view.tv_normal_pick_pay_status
            val content = view.tv_normal_pick_content
            val btn = view.btn_rec_item_scan_normal
            return MViewHolder(view, title, boxId, date, userName, payStatus, content, btn)
        }
    }

    private class MViewHolder(
        itemView: View,
        val title: TextView,
        val boxId: TextView,
        val date: TextView,
        val userName: TextView,
        val payStatus: TextView,
        val content: TextView,
        val btn: Button
    ) : RecyclerView.ViewHolder(itemView)

    override val controller: ItemController
        get() = Controller
}

fun MutableList<Item>.add(position: Int, boxId: String, date: String, name: String, status: String, content: String) =
    add(NormalPickItem(position,boxId,date,name,status,content))