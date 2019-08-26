package com.app.oto.otoapplication.home

import android.os.Bundle
import android.support.v7.widget.CardView
import android.widget.ImageView
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity
import com.app.oto.otoapplication.personal.base.getMyIntent
import com.app.oto.otoapplication.scan.ScanHome
import kotlinx.android.synthetic.main.activity_home_main.view.*

class homeMainpageActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_main)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {

        findViewById<CardView>(R.id.main_message).setOnClickListener {
           startActivity(getMyIntent(this,MessageActivity::class.java))
        }

        findViewById<CardView>(R.id.main_send).setOnClickListener {
            startActivity(getMyIntent(this,SendActivity::class.java))
        }

        findViewById<CardView>(R.id.main_my_baggage).setOnClickListener {
            startActivity(getMyIntent(this,MyBaggageActivity::class.java))
        }
    }

    override fun initToolbar() {
        findViewById<ImageView>(R.id.scanner).setOnClickListener {
            startActivity(getMyIntent(this,ScanHome::class.java))
        }
    }

}