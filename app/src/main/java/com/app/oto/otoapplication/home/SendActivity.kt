package com.app.oto.otoapplication.home

import android.os.Bundle
import android.widget.TextView
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity
import com.app.oto.otoapplication.personal.base.getMyIntent

class SendActivity:BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_wantsend)
        super.onCreate(savedInstanceState)
    }


    override fun initView() {
    findViewById<TextView>(R.id.send_confirm).setOnClickListener {
        startActivity(getMyIntent(this,senddetailActivity::class.java))
    }
    }

    override fun initToolbar() {
        supportActionBar?.title = "寄件"
    }
}