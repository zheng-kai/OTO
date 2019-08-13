package com.app.oto.otoapplication.transport

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cn.edu.twt.retrox.recyclerviewdsl.Item
import cn.edu.twt.retrox.recyclerviewdsl.ItemController
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.layoutInflater
import kotlinx.android.synthetic.main.rec_item_order.view.*

class OrderItem(val userInfo: String, val size: String, val price: String) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as MViewHolder
            item as OrderItem
            item.apply {
                val userStr = "用户设置：${item.userInfo}"
                val sizeStr = "智能环保箱尺寸：${item.size}"
                val priceStr = "该单价格：${item.price}"
                holder.apply {
                    userTV.text = userStr
                    sizeTV.text = sizeStr
                    priceTV.text = priceStr
                }
            }
            holder.confirm.setOnClickListener {

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val view = parent.context.layoutInflater.inflate(R.layout.rec_item_order, parent, false)
            val userTV =  view.tv_rec_user_order
            val sizeTV =  view.tv_rec_size_order
            val priceTV = view.tv_rec_price_order
            val confirm = view.btn_rec_confirm_order
            return MViewHolder(view, userTV, sizeTV, priceTV, confirm)
        }
    }

    override val controller: ItemController
        get() = Controller

    private class MViewHolder(
        itemView: View,
        val userTV: TextView,
        val sizeTV: TextView,
        val priceTV: TextView,
        val confirm: Button
    ) :
        RecyclerView.ViewHolder(itemView)
}

fun MutableList<Item>.add(userInfo: String, size: String, price: String) = add(OrderItem(userInfo, size, price))