package com.app.oto.otoapplication.personal.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.app.oto.otoapplication.R

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.personal_toolbar))
        initToolbar()
        initView()
    }

    abstract fun initView()
    abstract fun initToolbar()
}