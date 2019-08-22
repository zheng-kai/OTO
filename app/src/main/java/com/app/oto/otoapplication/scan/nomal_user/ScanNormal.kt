package com.app.oto.otoapplication.scan.nomal_user

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.GridViewAdapter
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.scan_result_normal.*
import kotlinx.android.synthetic.main.scan_result_normal.view.*

class ScanNormal:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_normal)
        scan_normal_navigation.apply {
            img_home.background = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
        }
        img_scan_normal_back.setOnClickListener {
            onBackPressed()
        }
        val title = "Ai空间" + intent.getStringExtra("title")
        tv_normal_title.text = title
        gridview_scan_normal.adapter = GridViewAdapter()
        btn_post.setOnClickListener {
            cd_scan_normal_boxes.visibility = View.VISIBLE
        }
        btn_pick_up.setOnClickListener {
            startActivity(Intent(this,NormalPick::class.java))
        }
        cd_scan_normal_boxes.btn_scan_normal_confirm.setOnClickListener {
            cd_scan_normal_boxes.visibility = View.INVISIBLE
        }
    }
}