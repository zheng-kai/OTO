package com.app.oto.otoapplication.scan

import android.graphics.Color
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import cn.edu.twt.retrox.recyclerviewdsl.Item
import cn.edu.twt.retrox.recyclerviewdsl.ItemController
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.CommonContext
import kotlinx.android.synthetic.main.rec_item_pick_car.view.*
import kotlinx.android.synthetic.main.rec_item_pick_crowdsource.view.*
import kotlinx.android.synthetic.main.rec_item_pick_normal.view.*
import kotlinx.android.synthetic.main.rec_item_post_normal.view.*
import kotlinx.android.synthetic.main.scan_result_crowdsource_pick.view.*
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
            return MViewHolder(
                view,
                title,
                boxId,
                date,
                userName,
                payStatus,
                content,
                btn
            )
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
    add(NormalPickItem(position, boxId, date, name, status, content))

class ScanCarRecItem(val position: Int, val boxId: String) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            item as ScanCarRecItem
            holder as MViewHolder
            val titleStr = "包裹${item.position}"
            val boxIdStr = "智能环保箱编号：${item.boxId}"
            holder.title.text = titleStr
            holder.boxId.text = boxIdStr
            holder.btn.setOnClickListener {
                holder.btn.background = ResourcesCompat.getDrawable(
                    CommonContext.application.resources,
                    R.drawable.button_background_orange,
                    null
                )
                holder.btn.text = "正在出库"
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val view = parent.context.layoutInflater.inflate(R.layout.rec_item_pick_car, parent, false)
            val title = view.tv_car_pick_title
            val boxId = view.tv_car_pick_box_id
            val btn = view.btn_car_pick
            return MViewHolder(view, title, boxId, btn)
        }

    }

    private class MViewHolder(itemView: View, val title: TextView, val boxId: TextView, val btn: Button) :
        RecyclerView.ViewHolder(itemView)

    override val controller: ItemController
        get() = Controller
}

fun MutableList<Item>.add(position: Int, boxId: String) = add(
    ScanCarRecItem(
        position,
        boxId
    )
)


class ScanCrowdsourceRecItem(
    val position: Int,
    val boxId: String,
    val destination: String,
    val userName: String,
    val phone: String
) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            item as ScanCrowdsourceRecItem
            holder as MViewHolder
            item.apply {
                val titleStr = "包裹$position"
                val boxIdStr = "智能环保箱编号：$boxId"
                val destinationStr = "送货地点：$destination"
                val userNameStr = "用户：$userName"
                val phoneStr = "联系电话：$phone"
                holder.apply {
                    title.text = titleStr
                    boxId.text = boxIdStr
                    destination.text = destinationStr
                    userName.text = userNameStr
                    phone.text = phoneStr
                    btn.setOnClickListener {
                        btn.background = ResourcesCompat.getDrawable(
                            CommonContext.application.resources,
                            R.drawable.button_background_orange,
                            null
                        )
                        btn.text = "正在出库"
                    }
                }

            }

        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val view = parent.context.layoutInflater.inflate(R.layout.rec_item_pick_crowdsource, parent, false)
            val title = view.tv_crowdsource_pick_title
            val boxId = view.tv_crowdsource_pick_box_id
            val destination = view.tv_crowdsource_pick_destination
            val userName = view.tv_crowdsource_pick_name
            val phone = view.tv_crowdsource_pick_phone
            val btn = view.btn_crowdsource_rec_item_pick
            return MViewHolder(view, title, boxId, destination, userName, phone, btn)
        }

    }

    private class MViewHolder(
        itemView: View,
        val title: TextView,
        val boxId: TextView,
        val destination: TextView,
        val userName: TextView,
        val phone: TextView,
        val btn: Button
    ) :
        RecyclerView.ViewHolder(itemView)

    override val controller: ItemController
        get() = Controller
}

fun MutableList<Item>.add(
    position: Int,
    boxId: String,
    destination: String,
    userName: String,
    phone: String
) = add(ScanCrowdsourceRecItem(position, boxId, destination, userName, phone))

class ScanNormalPostRecItem(val name: String, val phone: String, val location: String) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            item as ScanNormalPostRecItem
            holder as MViewHolder
            holder.apply {
                name.text = item.name
                phone.text = item.phone
                location.text = item.location
                post.setOnClickListener {

                }
                selectImg.setOnClickListener {
                    if (it.background == ResourcesCompat.getDrawable(
                            CommonContext.application.resources,
                            R.mipmap.checkout_selected,
                            null
                        )
                    ) {
                        it.background = ResourcesCompat.getDrawable(
                            CommonContext.application.resources,
                            R.mipmap.checkout_unselected,
                            null
                        )
                        post.visibility = View.INVISIBLE
                    } else {
                        it.background = ResourcesCompat.getDrawable(
                            CommonContext.application.resources,
                            R.mipmap.checkout_selected,
                            null
                        )
                        post.visibility = View.VISIBLE
                    }

                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            val itemView = parent.context.layoutInflater.inflate(R.layout.rec_item_post_normal, parent, false)
            val name = itemView.tv_normal_post_name
            val phone = itemView.tv_normal_post_phone
            val location = itemView.tv_normal_post_location
            val post = itemView.btn_normal_post
            val selectImg = itemView.img_normal_post_select
            return MViewHolder(itemView, name, phone, location, post, selectImg)
        }

    }

    private class MViewHolder(
        itemView: View,
        val name: TextView,
        val phone: TextView,
        val location: TextView,
        val post: Button,
        val selectImg: ImageView
    ) : RecyclerView.ViewHolder(itemView)

    override val controller: ItemController
        get() = Controller
}

fun MutableList<Item>.add(
     name: String,
     phone: String,
     location: String
) = add(ScanNormalPostRecItem(name,phone,location))