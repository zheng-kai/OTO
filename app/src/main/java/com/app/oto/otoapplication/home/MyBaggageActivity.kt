package com.app.oto.otoapplication.home

import android.os.Bundle
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity

class MyBaggageActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_mypackage)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {

    }

    override fun initToolbar() {
        supportActionBar?.title = "我的包裹"
    }
}