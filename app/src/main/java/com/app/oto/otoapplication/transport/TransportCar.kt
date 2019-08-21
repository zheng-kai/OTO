package com.app.oto.otoapplication.transport

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.ScanHome
import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_car.*
import com.baidu.location.LocationClientOption
import com.baidu.location.LocationClient
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.MapView
import com.baidu.mapapi.map.MyLocationData
import com.baidu.mapapi.map.MarkerOptions
import com.baidu.mapapi.map.OverlayOptions
import com.baidu.mapapi.map.BitmapDescriptorFactory
import com.baidu.mapapi.map.BitmapDescriptor
import com.baidu.mapapi.model.LatLng


class TransportCar : AppCompatActivity() {
    lateinit var baiduMap: BaiduMap
    lateinit var mLocationClient: LocationClient
    var mapView: MapView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transport_car)
        img_car_back.setOnClickListener {
            onBackPressed()
        }
        transport_car_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources, R.mipmap.transport_clicked, null)
            btn_transport.setOnClickListener {
                startActivity(Intent(this@TransportCar,TransportHome::class.java))
            }
        }
        rec_transport_car.layoutManager = LinearLayoutManager(this)
        rec_transport_car.withItems {
            for (i in 1..5) {
                add("xxxxx", "A", "$i 元")
            }
        }
        img_car_scan.setOnClickListener {
            startActivity(Intent(this, ScanHome::class.java))
        }
        mapView = map_transport_car
        baiduMap = map_transport_car.map
        baiduMap.isTrafficEnabled = true
        baiduMap.isMyLocationEnabled = true
        baiduMap.setOnMarkerClickListener {
            false
        }
        //定位初始化
        mLocationClient = LocationClient(this)

        //通过LocationClientOption设置LocationClient相关参数
        val option = LocationClientOption()
        option.isOpenGps = true // 打开gps
        option.setCoorType("bd09ll") // 设置坐标类型
        option.setScanSpan(1000)
        option.locationMode = LocationClientOption.LocationMode.Hight_Accuracy
        //设置locationClientOption
        mLocationClient.locOption = option

        //注册LocationListener监听器
        val myLocationListener = ALocationListener()
        mLocationClient.registerLocationListener(myLocationListener)

        //定义Maker坐标点
        val point = LatLng(39.963175, 116.400244)
        //构建Marker图标
        val bitmap = BitmapDescriptorFactory
            .fromResource(R.mipmap.location)
        //构建MarkerOption，用于在地图上添加Marker
        val markOption = MarkerOptions()
            .position(point)
            .icon(bitmap)
        //在地图上添加Marker，并显示
        baiduMap.addOverlay(markOption)
        //开启地图定位图层
        mLocationClient.start()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onDestroy() {
        mLocationClient.stop()
        baiduMap.isMyLocationEnabled = false
        mapView?.onDestroy()
        mapView = null
        super.onDestroy()

    }

    inner class ALocationListener : BDAbstractLocationListener() {
        override fun onReceiveLocation(location: BDLocation?) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mapView == null) {
                return
            }
            val locData = MyLocationData.Builder()
                .accuracy(location.radius)
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(location.direction).latitude(location.latitude)
                .longitude(location.longitude).build()
            location.altitude
            location.latitude
            location.locationWhere
            baiduMap.setMyLocationData(locData)
        }
    }
}