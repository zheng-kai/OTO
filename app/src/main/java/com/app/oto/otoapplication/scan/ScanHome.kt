package com.app.oto.otoapplication.scan

import android.content.Context
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import cn.bingoogolapple.qrcode.core.QRCodeView
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.home_activity_scan.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import android.os.Vibrator
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import cn.bingoogolapple.qrcode.core.BarcodeType
import com.app.oto.otoapplication.commons.CommonContext
import java.security.Permission
import java.util.jar.Manifest


class ScanHome:AppCompatActivity(),QRCodeView.Delegate {
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

    override fun onStart() {
        super.onStart()

        zx_scan.startCamera() // 打开后置摄像头开始预览，但是并未开始识别
        //        mZXingView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT); // 打开前置摄像头开始预览，但是并未开始识别
        zx_scan.setType(BarcodeType.TWO_DIMENSION, null) // 只识别二维条码
        zx_scan.startSpotAndShowRect() // 显示扫描框，并开始识别
    }

    override fun onStop() {
        zx_scan.stopCamera() // 关闭摄像头预览，并且隐藏扫描框
        super.onStop()
    }

    override fun onDestroy() {
        zx_scan.onDestroy() // 销毁二维码扫描控件
        super.onDestroy()
    }

    private fun vibrate() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(200L)
    }

    override fun onScanQRCodeSuccess(result: String) {
        title = "扫描结果为：$result"
        vibrate()
        Log.d("scanResult",result)
        zx_scan.startSpot() // 开始识别
    }

    override fun onCameraAmbientBrightnessChanged(isDark: Boolean) {
        // 这里是通过修改提示文案来展示环境是否过暗的状态，接入方也可以根据 isDark 的值来实现其他交互效果
        var tipText = zx_scan.scanBoxView.tipText
        val ambientBrightnessTip = "\n环境过暗，请打开闪光灯"
        if (isDark) {
            if (!tipText.contains(ambientBrightnessTip)) {
                zx_scan.scanBoxView.tipText = tipText + ambientBrightnessTip
            }
        } else {
            if (tipText.contains(ambientBrightnessTip)) {
                tipText = tipText.substring(0, tipText.indexOf(ambientBrightnessTip))
                zx_scan.scanBoxView.tipText = tipText
            }
        }
    }

    override fun onScanQRCodeOpenCameraError() {
        Toast.makeText(this,"打开相机出错,检查相机权限.",Toast.LENGTH_LONG).show()
    }

}