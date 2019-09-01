package com.app.oto.otoapplication.home

import android.os.Bundle
import android.support.v7.widget.CardView
import android.widget.ImageView
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity
import com.app.oto.otoapplication.personal.base.getMyIntent
import com.app.oto.otoapplication.scan.ScanHome
import com.app.oto.otoapplication.transport.MyLocationListener
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.MapView
import kotlinx.android.synthetic.main.navigation_layout.*
/*
class homeMainpageActivity: BaseActivity() {
    private lateinit var mMapView: MapView
    private lateinit var mMap:BaiduMap
    private lateinit var mLocationClient: LocationClient
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_main)
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        mMapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mMapView.onPause()
    }

    override fun onDestroy() {
        mLocationClient.stop()
        mMap.isMyLocationEnabled = false
        mMapView.onDestroy()
        super.onDestroy()
    }

    override fun initView() {
        img_transport.setOnClickListener {

        }
        mMapView = findViewById(R.id.map_home)
        mMap = mMapView.map
        mMap.mapType= BaiduMap.MAP_TYPE_SATELLITE
        mMap.isMyLocationEnabled = true
        mLocationClient = LocationClient(this)
        val option = LocationClientOption()
        option.apply {
            openGps = true
            coorType = "bd09ll"
            scanSpan = 1000
        }
        mLocationClient.locOption = option
        val myLocationListener = MyLocationListener(mMap,mMapView)
        mLocationClient.registerLocationListener(myLocationListener)
        mLocationClient.start()

        findViewById<CardView>(R.id.main_message).setOnClickListener {
           startActivity(getMyIntent(this,MessageActivity::class.java))
        }

        findViewById<CardView>(R.id.main_send).setOnClickListener {
            startActivity(getMyIntent(this,SendActivity::class.java))
        }

        findViewById<CardView>(R.id.main_my_baggage).setOnClickListener {
            startActivity(getMyIntent(this,MyBaggageActivity::class.java))
        }
    }

    override fun initToolbar() {
        //findViewById<ImageView>(R.id.scanner).setOnClickListener {
        //    startActivity(getMyIntent(this,ScanHome::class.java))
        //}
    }


}
*/