package com.app.oto.otoapplication.transport

import com.app.oto.otoapplication.R.mipmap.location
import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.MapView
import com.baidu.mapapi.map.MyLocationData


class MyLocationListener(val mBaiduMap: BaiduMap, val mMapView: MapView?) : BDAbstractLocationListener() {
    override fun onReceiveLocation(location: BDLocation?) {
        //mapView 销毁后不在处理新接收的位置
        if (location == null || mMapView == null) {
            return
        }
        val locData = MyLocationData.Builder()
            .accuracy(location.radius)
            // 此处设置开发者获取到的方向信息，顺时针0-360
            .direction(location.direction).latitude(location.latitude)
            .longitude(location.longitude).build()
        mBaiduMap.setMyLocationData(locData)
    }
}