package com.app.oto.otoapplication.scan

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import cn.bingoogolapple.qrcode.core.QRCodeView
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.home_activity_scan.*
import kotlinx.android.synthetic.main.navigation_layout.view.*

class ScanHome:AppCompatActivity(),QRCodeView.Delegate {
    override fun onScanQRCodeSuccess(result: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCameraAmbientBrightnessChanged(isDark: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onScanQRCodeOpenCameraError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_scan)
        scan_home_navigation.apply {
            btn_home.background = ResourcesCompat.getDrawable(resources,R.mipmap.home_clicked,null)
        }
        img_scan_back.setOnClickListener {
            onBackPressed()
        }
        zx_scan.setDelegate(this)
    }
}