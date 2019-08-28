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

class MyBaggageActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_mypackage)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        transport_car_navigation.apply {
            img_transport.image = ResourcesCompat.getDrawable(resources, R.mipmap.transport_clicked, null)
            setNavigationClickListener(this@MyBaggageActivity)
        }
    }

    override fun initToolbar() {
        supportActionBar?.title = "我的包裹"
        back.setOnClickListener {
            onBackPressed()
        }
    }

}