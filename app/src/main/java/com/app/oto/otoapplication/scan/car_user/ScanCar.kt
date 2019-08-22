package com.app.oto.otoapplication.scan.car_user

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.add
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.scan_result_car.*

class ScanCar:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_car)
        scan_car_pick_up_navigation.apply {
            img_home.background = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
        }
        img_car_pick_back.setOnClickListener {
            onBackPressed()
        }
        rec_car_pick.layoutManager = LinearLayoutManager(this)
        rec_car_pick.withItems {
            for(i in 1..4){
                add(i,"1234567805")
            }
        }
    }
}