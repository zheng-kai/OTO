package com.app.oto.otoapplication.home

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.setNavigationClickListener
import com.app.oto.otoapplication.personal.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home_message.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_car.*
import org.jetbrains.anko.image

class MessageActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_message)
        super.onCreate(savedInstanceState)
    }
    override fun initView() {
        transport_home_navigation.apply {
            img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
            setNavigationClickListener(this@MessageActivity)
        }
    }

    override fun initToolbar() {
        supportActionBar?.title = "我的消息"
        back.setOnClickListener {
            onBackPressed()
        }

    }
}