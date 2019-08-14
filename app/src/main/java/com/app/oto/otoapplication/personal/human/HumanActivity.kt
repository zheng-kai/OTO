package com.app.oto.otoapplication.personal.human

import android.os.Bundle
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity

class HumanActivity : BaseActivity() {
    override fun initView() {

    }

    override fun initToolbar() {
        supportActionBar?.title = "众包人员认证"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.personal_human_layout)
        super.onCreate(savedInstanceState)

    }
}
