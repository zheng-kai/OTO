package com.app.oto.otoapplication.transport

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.car_user.ScanCar
import com.app.oto.otoapplication.scan.crowdsource_user.ScanCrowdsource
import com.app.oto.otoapplication.scan.nomal_user.NormalPost
import com.app.oto.otoapplication.scan.nomal_user.ScanNormal
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_crowdsource.*
import com.baidu.location.LocationClientOption
import com.baidu.location.LocationClient



class TransportCrowdsource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transport_crowdsource)
        img_crowdsource_back.setOnClickListener {
            onBackPressed()
        }
        transport_crowdsource_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources,R.mipmap.transport_clicked,null)
        }
        rec_transport_crowdsource.layoutManager = LinearLayoutManager(this)
        rec_transport_crowdsource.withItems {
            for(i in 1..5){
                add("xxxxx","A","$i 元")
            }
        }
        img_crowdsource_scan.setOnClickListener {
            startActivity(Intent(this, NormalPost::class.java))
        }
        val baiduMap = map_transport_crowdscource.map
//        baiduMap.isTrafficEnabled = true
        baiduMap.isMyLocationEnabled = true

        //定位初始化
        val mLocationClient = LocationClient(this)

        //通过LocationClientOption设置LocationClient相关参数
        val option = LocationClientOption()
        option.isOpenGps = true // 打开gps
        option.setCoorType("bd09ll") // 设置坐标类型
        option.setScanSpan(1000)

        //设置locationClientOption
        mLocationClient.locOption = option

        //注册LocationListener监听器
        val myLocationListener = MyLocationListener(baiduMap,map_transport_crowdscource)
        mLocationClient.registerLocationListener(myLocationListener)
        //开启地图定位图层
        mLocationClient.start()

    }
    override fun onResume() {
        super.onResume()
        map_transport_crowdscource.onResume()
    }

    override fun onPause() {
        super.onPause()
        map_transport_crowdscource.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        map_transport_crowdscource.onDestroy()
    }
}