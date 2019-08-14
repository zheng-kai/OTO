package com.app.oto.otoapplication.personal.friend

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseRVAdapter

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
            MAIN_TYPE -> viewHolder = MainHolder(layoutInflater.inflate(R.layout.friend_rv_card, viewGroup, false))
            ADD_TYPE -> viewHolder = AddHolder(layoutInflater.inflate(R.layout.friend_rv_add, viewGroup, false))
        }
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {

        }
    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class AddHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}