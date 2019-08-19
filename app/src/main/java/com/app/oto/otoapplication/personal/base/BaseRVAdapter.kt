package com.app.oto.otoapplication.personal.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

abstract class BaseRVAdapter(protected var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    protected var layoutInflater: LayoutInflater = LayoutInflater.from(context)
}