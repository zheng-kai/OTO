package com.app.oto.otoapplication.home

import android.os.Bundle
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity

class SendActivity:BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_wantsend)
        super.onCreate(savedInstanceState)
    }


    override fun initView() {

    }

    override fun initToolbar() {
        supportActionBar?.title = "寄件"
    }
}