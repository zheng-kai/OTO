package com.app.oto.otoapplication.transport

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.setNavigationClickListener
import com.app.oto.otoapplication.scan.ScanHome
import com.app.oto.otoapplication.scan.nomal_user.NormalPost
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_crowdsource.*
import com.baidu.location.LocationClientOption
import com.baidu.location.LocationClient
import org.jetbrains.anko.image
import org.jetbrains.anko.startActivity


class TransportCrowdsource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transport_crowdsource)
        img_crowdsource_back.setOnClickListener {
            onBackPressed()
        }
        transport_crowdsource_navigation.apply {
            img_transport.image = ResourcesCompat.getDrawable(resources,R.mipmap.transport_clicked,null)
            setNavigationClickListener(this@TransportCrowdsource)
        }
        rec_transport_crowdsource.layoutManager = LinearLayoutManager(this)
        rec_transport_crowdsource.withItems {
            for(i in 1..5){
                add("xxxxx","A","$i 元")
            }
        }
        img_crowdsource_scan.setOnClickListener {
            val intent = Intent(this, ScanHome::class.java)
            intent.putExtra("type","CrowdSource")
            startActivity(intent)
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