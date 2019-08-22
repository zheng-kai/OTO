package com.app.oto.otoapplication.scan.nomal_user

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.add
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.scan_result_normal_pick.*

class NormalPick :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_normal_pick)
        scan_pick_up_navigation.apply {
            img_home.background = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
        }
        img_pick_up_back.setOnClickListener {
            onBackPressed()
        }
        rec_normal_pick.layoutManager = LinearLayoutManager(this)
        rec_normal_pick.withItems {
            for(i in 1..2){
                add(i,"1234567805","2019-8-1 8:30","Jack","未付款","xxxxxxxxxxxxxxxxxxxx")
            }
            add(3,"1234567805","2019-8-1 8:30","Jack","已付款","xxxxxxxxxxxxxxxxxxxx")

        }
    }
}