package com.app.oto.otoapplication.scan.nomal_user

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.scan_result_normal_post_pay.*
import org.jetbrains.anko.image

class NormalPostPay:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_normal_post_pay)
        scan_normal_post_pay_navigation.apply {
            img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
        }
        img_post_pay_back.setOnClickListener {
            onBackPressed()
        }
    }
}