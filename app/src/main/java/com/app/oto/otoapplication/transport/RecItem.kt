package com.app.oto.otoapplication.transport

import android.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import cn.edu.twt.retrox.recyclerviewdsl.Item
import cn.edu.twt.retrox.recyclerviewdsl.ItemController
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.dialog_cancel_order.view.*
import kotlinx.android.synthetic.main.rec_item_order.view.*
import kotlinx.android.synthetic.main.rec_item_ordered_car.view.*
import kotlinx.android.synthetic.main.rec_item_ordered_crowdsource.view.*
import org.jetbrains.anko.layoutInflater

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
            val userTV = view.tv_rec_user_order
            val sizeTV = view.tv_rec_size_order
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

class OrderedCarItem(val boxId: String, val destination: String, val price: String) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as MViewHolder
            item as OrderedCarItem
            item.apply {
                val boxIdStr = "智能环保箱编号：${item.boxId}"
                val destinationStr = "目的地：${item.destination}"
                val priceStr = "该单价格：${item.price}"
                holder.apply {
                    boxIdTV.text = boxIdStr
                    destinationTV.text = destinationStr
                    priceTV.text = priceStr
                }
            }
            holder.cancelBtn.setOnClickListener {
                val view = LayoutInflater.from(holder.itemView.context).inflate(R.layout.dialog_cancel_order,null)
                val dialog =  AlertDialog.Builder(holder.itemView.context).setView(view).create()
                view.dialog_cancel.setOnClickListener {
                    dialog.dismiss()
                }
                view.dialog_confirm.setOnClickListener {
                    dialog.dismiss()
                    // 撤销接单
                }
                dialog.show()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val view = parent.context.layoutInflater.inflate(R.layout.rec_item_ordered_car, parent, false)
            val boxIdTV = view.tv_rec_box_id_car
            val destinationTV = view.tv_rec_destination_car
            val priceTV = view.tv_rec_price_ordered_car
            val cancelBtn = view.btn_rec_cancel_ordered_car
            return MViewHolder(view, boxIdTV, destinationTV, priceTV, cancelBtn)
        }
    }

    override val controller: ItemController
        get() = Controller

    private class MViewHolder(
        itemView: View,
        val boxIdTV: TextView,
        val destinationTV: TextView,
        val priceTV: TextView,
        val cancelBtn: Button
    ) :
        RecyclerView.ViewHolder(itemView)
}

fun MutableList<Item>.addOrdered(boxId: String, destination: String, price: String) =
    add(OrderedCarItem(boxId, destination, price))

class OrderedCrowdsourceItem(val boxId: String, val phone: String, val destination: String, val price: String) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as MViewHolder
            item as OrderedCrowdsourceItem
            item.apply {
                val boxIdStr = "智能环保箱编号：${item.boxId}"
                val phoneStr = "联系人电话：${item.phone}"
                val destinationStr = "目的地：${item.destination}"
                val priceStr = "该单价格：${item.price}"
                holder.apply {
                    boxIdTV.text = boxIdStr
                    phoneTV.text = phoneStr
                    destinationTV.text = destinationStr
                    priceTV.text = priceStr
                }
            }
            holder.cancelBtn.setOnClickListener {
                val view = LayoutInflater.from(holder.itemView.context).inflate(R.layout.dialog_cancel_order,null)
                val dialog =  AlertDialog.Builder(holder.itemView.context).setView(view).create()
                view.dialog_cancel.setOnClickListener {
                    dialog.dismiss()
                }
                view.dialog_confirm.setOnClickListener {
                    dialog.dismiss()
                    // 撤销接单
                }
                dialog.show()
            }
            holder.callBtn.setOnClickListener {

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val view = parent.context.layoutInflater.inflate(R.layout.rec_item_ordered_crowdsource, parent, false)
            val boxIdTV = view.tv_rec_box_id_crowdsource
            val phoneTV = view.tv_rec_phone_crowdsource
            val destinationTV = view.tv_rec_destination_crowdsource
            val priceTV = view.tv_rec_price_ordered_crowdsource
            val cancelBtn = view.btn_rec_cancel_ordered_crowdsource
            val callBtn = view.btn_rec_call_crowdsource
            return MViewHolder(view, boxIdTV, phoneTV,destinationTV, priceTV, cancelBtn,callBtn)
        }
    }

    override val controller: ItemController
        get() = Controller

    private class MViewHolder(
        itemView: View,
        val boxIdTV: TextView,
        val phoneTV: TextView,
        val destinationTV: TextView,
        val priceTV: TextView,
        val cancelBtn: Button,
        val callBtn: Button
    ) :
        RecyclerView.ViewHolder(itemView)
}
fun MutableList<Item>.addOrdered(boxId: String, phone:String,destination: String, price: String) =
    add(OrderedCrowdsourceItem(boxId, phone,destination, price))