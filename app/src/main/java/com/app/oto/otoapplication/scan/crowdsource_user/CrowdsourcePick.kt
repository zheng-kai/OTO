package com.app.oto.otoapplication.scan.crowdsource_user

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.add
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.scan_result_crowdsource_pick.*
import org.jetbrains.anko.image

class CrowdsourcePick:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_crowdsource_pick)
        scan_crowdsource_pick_up_navigation.apply {
            img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
        }
        img_crowdsource_pick_up_back.setOnClickListener {
            onBackPressed()
        }
        rec_crowdsource_pick.layoutManager = LinearLayoutManager(this)
        rec_crowdsource_pick.withItems {
            for(i in 1..3){
                add(i,"1234567805","xxxxxxxx","Jacd","1524592120")
            }
        }
    }
}