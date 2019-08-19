package com.app.oto.otoapplication.personal.vehicle

import android.os.Bundle
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity

class VehicleActivity : BaseActivity() {
    override fun initToolbar() {
        supportActionBar?.title = "顺丰私家车认证"
    }

    override fun initView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.personal_vehicle_layout)
        super.onCreate(savedInstanceState)
    }
}
