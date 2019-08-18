package com.app.oto.otoapplication.transport

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_ordered.*
import kotlin.random.Random

class TransportOrdered:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transport_ordered)
        img_order_back.setOnClickListener {
            onBackPressed()
        }
        transport_order_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources,R.mipmap.transport_clicked,null)
        }
        rec_car_transport_ordered.layoutManager = LinearLayoutManager(this)
        rec_car_transport_ordered.withItems {
            for(i in 1..5){
                addOrdered("${Random(i).nextInt()}","xxxxxx","$i 元")
            }
        }
        rec_crowdsource_transport_ordered.layoutManager = LinearLayoutManager(this)
        rec_crowdsource_transport_ordered.withItems {
            for(i in 1..8){
                addOrdered("${Random(i).nextInt()}","182****1548","xxxxxx","$i 元")
            }
        }
    }
    override fun onResume() {
        super.onResume()
        map_transport_ordered.onResume()
    }

    override fun onPause() {
        super.onPause()
        map_transport_ordered.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        map_transport_ordered.onDestroy()
    }
}