package com.app.oto.otoapplication.transport

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.ScanHome
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_car.*

class TransportCar:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transport_car)
        img_car_back.setOnClickListener {
            onBackPressed()
        }
        transport_car_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources,R.mipmap.transport_clicked,null)
        }
        rec_transport_car.layoutManager = LinearLayoutManager(this)
        rec_transport_car.withItems {
            for(i in 1..5){
                add("xxxxx","A","$i 元")
            }
        }
        img_car_scan.setOnClickListener {
            startActivity(Intent(this,ScanHome::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        map_transport_car.onResume()
    }

    override fun onPause() {
        super.onPause()
        map_transport_car.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        map_transport_car.onDestroy()
    }
}