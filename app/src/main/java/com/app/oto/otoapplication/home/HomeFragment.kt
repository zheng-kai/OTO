package com.app.oto.otoapplication.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.CommonContext
import com.app.oto.otoapplication.scan.nomal_user.ScanNormal
import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.*
import com.baidu.mapapi.model.LatLng
import kotlinx.android.synthetic.main.activity_home_main.*
import kotlinx.android.synthetic.main.activity_home_main.view.*
import kotlinx.android.synthetic.main.transport_car.*

class HomeFragment: Fragment(){
    lateinit var baiduMap: BaiduMap
    lateinit var mLocationClient: LocationClient
    var mapView: MapView? = null
companion object {
 fun newInstance():HomeFragment{
     return HomeFragment()
 }
}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mview = inflater.inflate(R.layout.activity_home_main,container,false)
        val message = mview.main_message
        val send = mview.main_send
        val myBaggage = mview.main_my_baggage
        mapView = map_home
        baiduMap = map_transport_car.map
        baiduMap.isTrafficEnabled = true
        baiduMap.isMyLocationEnabled = true
        baiduMap.setOnMarkerClickListener {
            false
        }
        //定位初始化
        mLocationClient = LocationClient(CommonContext.application)

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
            .perspective(true)
            .icon(bitmap)
        //在地图上添加Marker，并显示
        baiduMap.addOverlay(markOption)
        //开启地图定位图层
        mLocationClient.start()

        mview.scanner.setOnClickListener {
            startActivity(Intent(CommonContext.application,ScanNormal::class.java))
        }
        message.setOnClickListener {
            startActivity(Intent(CommonContext.application,MessageActivity::class.java))
        }
        send.setOnClickListener {
            startActivity(Intent(CommonContext.application,SendActivity::class.java))
        }
        myBaggage.setOnClickListener {
            startActivity(Intent(CommonContext.application,MyBaggageActivity::class.java))
        }
        return mview
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