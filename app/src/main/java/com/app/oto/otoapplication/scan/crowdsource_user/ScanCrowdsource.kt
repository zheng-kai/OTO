package com.app.oto.otoapplication.scan.crowdsource_user

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.GridViewAdapter
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.scan_result_crowdsource.*
import kotlinx.android.synthetic.main.scan_result_crowdsource.view.*
import kotlinx.android.synthetic.main.transport_crowdsource.*

class ScanCrowdsource:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_crowdsource)
        scan_crowdsource_navigation.apply {
            btn_home.background = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
        }
        img_scan_crowdsource_back.setOnClickListener {
            onBackPressed()
        }
        btn_crowdsource_post.setOnClickListener {
            cd_scan_crowdsource_boxes.visibility = View.VISIBLE
        }
        cd_scan_crowdsource_boxes.btn_scan_crowdsource_confirm.setOnClickListener {
            cd_scan_crowdsource_boxes.visibility = View.INVISIBLE
        }
        gridview_scan_crowdsource.adapter = GridViewAdapter()
    }
}