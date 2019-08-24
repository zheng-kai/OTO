package com.app.oto.otoapplication.personal.friend

import android.app.ActionBar
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupWindow
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseRVAdapter
import com.app.oto.otoapplication.personal.base.test

class FriendAdapter(context: Context) : BaseRVAdapter(context) {

    companion object {
        const val MAIN_TYPE = 0
        const val ADD_TYPE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            11 -> ADD_TYPE
            else -> MAIN_TYPE
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        lateinit var viewHolder: RecyclerView.ViewHolder
        when (viewType) {
            MAIN_TYPE -> viewHolder = MainHolder(
                layoutInflater.inflate(
                    R.layout.personal_friend_rv_card,
                    viewGroup,
                    false
                )
            )
            ADD_TYPE -> viewHolder =
                AddHolder(layoutInflater.inflate(R.layout.personal_friend_rv_add, viewGroup, false))
        }
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            MAIN_TYPE -> {
                (viewHolder as MainHolder).deleteIcon.setOnClickListener {

                }
            }
            ADD_TYPE -> {
                (viewHolder as AddHolder).addBtn.setOnClickListener {
                    val popupWindow =
                        PopupWindow(layoutInflater.inflate(R.layout.personal_friend_popup, null),
                            ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                    popupWindow.showAtLocation(layoutInflater.inflate(R.layout.personal_friend_popup,null),Gravity.CENTER,0,0)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val deleteIcon: ImageView = itemView.findViewById(R.id.delete)
    }

    inner class AddHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val addBtn: ImageButton = itemView.findViewById(R.id.add_btn)
    }
}