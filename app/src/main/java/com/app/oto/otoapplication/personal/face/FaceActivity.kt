package com.app.oto.otoapplication.personal.face

import android.os.Bundle
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity

class FaceActivity : BaseActivity() {
    override fun initToolbar() {
        supportActionBar?.title = "人脸识别认证"
    }

    override fun initView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.personal_face_layout)
        super.onCreate(savedInstanceState)
    }
}
