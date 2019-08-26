package com.app.oto.otoapplication.scan.crowdsource_user

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.setNavigationClickListener
import com.app.oto.otoapplication.scan.GridViewAdapter
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.scan_result_crowdsource.*
import kotlinx.android.synthetic.main.scan_result_crowdsource.view.*
import org.jetbrains.anko.image

class ScanCrowdsource:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_crowdsource)
        scan_crowdsource_navigation.apply {
            img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
            setNavigationClickListener(this@ScanCrowdsource)
        }
        img_scan_crowdsource_back.setOnClickListener {
            onBackPressed()
        }
        btn_crowdsource_post.setOnClickListener {
            cd_scan_crowdsource_boxes.visibility = View.VISIBLE
        }
        btn_crowdsource_pick_up.setOnClickListener {
            startActivity(Intent(this,CrowdsourcePick::class.java))
        }
        cd_scan_crowdsource_boxes.btn_scan_crowdsource_confirm.setOnClickListener {
            cd_scan_crowdsource_boxes.visibility = View.INVISIBLE
        }
        gridview_scan_crowdsource.adapter = GridViewAdapter()
    }
}