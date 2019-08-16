package com.app.oto.otoapplication.scan.nomaluser

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.scan_result_normal.*
import kotlinx.android.synthetic.main.scan_result_normal.view.*

class ScanNormal:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_normal)
        img_scan_normal_back.setOnClickListener {
            onBackPressed()
        }
        val title = "Ai空间" + intent.getStringExtra("title")
        tv_normal_title.text = title
        gridview_scan_normal.adapter = GridViewAdapter()
        cd_post.setOnClickListener {
            cd_scan_normal_boxes.visibility = View.VISIBLE
        }
        cd_scan_normal_boxes.btn_scan_normal_confirm.setOnClickListener {
            cd_scan_normal_boxes.visibility = View.INVISIBLE
        }
    }
}