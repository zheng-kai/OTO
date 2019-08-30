package com.app.oto.otoapplication.home

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.widget.TextView
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.setNavigationClickListener
import com.app.oto.otoapplication.personal.base.BaseActivity
import com.app.oto.otoapplication.personal.base.getMyIntent
import kotlinx.android.synthetic.main.activity_home_message.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_car.*
import org.jetbrains.anko.image

class SendActivity:BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_wantsend)
        super.onCreate(savedInstanceState)
    }


    override fun initView() {
    findViewById<TextView>(R.id.send_confirm).setOnClickListener {
        startActivity(getMyIntent(this,senddetailActivity::class.java))
    }
        transport_home_navigation.apply {
            img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
            setNavigationClickListener(this@SendActivity)
        }
    }

    override fun initToolbar() {
        supportActionBar?.title = "寄件"
        back.setOnClickListener {
            onBackPressed()
        }
    }

}