package com.app.oto.otoapplication.personal.friend

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity

class FriendActivity : BaseActivity() {
    override fun initToolbar() {
        supportActionBar?.title = "管理常用联系人"
    }

    private lateinit var recyclerView: RecyclerView
    override fun initView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.personal_friend_layout)
        super.onCreate(savedInstanceState)
        recyclerView = findViewById(R.id.friend_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FriendAdapter(this)
    }
}
