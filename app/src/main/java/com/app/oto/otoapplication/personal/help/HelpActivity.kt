package com.app.oto.otoapplication.personal.help

import android.os.Bundle
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity

class HelpActivity : BaseActivity() {
    override fun initView() {
    }

    override fun initToolbar() {
        supportActionBar?.title = "帮助"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.personal_help_layout)
        super.onCreate(savedInstanceState)
    }
}
