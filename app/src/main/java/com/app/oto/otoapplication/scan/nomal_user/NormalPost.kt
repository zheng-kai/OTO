package com.app.oto.otoapplication.scan.nomal_user

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.animation.AnimationUtils
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.add
import com.app.oto.otoapplication.transport.TransportHome
import com.app.oto.otoapplication.transport.add
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.scan_result_normal_post.*
import org.jetbrains.anko.startActivity

class NormalPost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_normal_post)
        val anim = AnimationUtils.loadAnimation(this, R.anim.dialog_top_in)
        scan_normal_post_navigation.apply {
            btn_home.background = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
            btn_transport.setOnClickListener {
                startActivity(Intent(this@NormalPost, TransportHome::class.java))
            }
        }
        img_post_back.setOnClickListener {
            onBackPressed()
        }
        rec_normal_post.layoutManager = LinearLayoutManager(this)
        rec_normal_post.withItems {
            for (i in 1..3) {
                add("Jack", "12345678910", "xxxxxxxxxxx") {
                    frame_normal_post_dialog.animation = anim
                    frame_normal_post_dialog.visibility = View.VISIBLE
                }
            }
        }
        btn_normal_custom_post.setOnClickListener {
            frame_normal_post_dialog.animation = anim
            frame_normal_post_dialog.visibility = View.VISIBLE
        }
        frame_normal_post_dialog.setOnClickListener {
            frame_normal_post_dialog.visibility = View.GONE
            startActivity(Intent(this, NormalPostPay::class.java))
        }
    }
}