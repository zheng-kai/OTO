package com.app.oto.otoapplication.scan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import cn.bingoogolapple.qrcode.core.QRCodeView
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.home_activity_scan.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import android.os.Vibrator
import android.util.Log
import android.widget.Toast
import cn.bingoogolapple.qrcode.core.BarcodeType
import com.app.oto.otoapplication.scan.nomal_user.ScanNormal
import pub.devrel.easypermissions.EasyPermissions


class ScanHome : AppCompatActivity(), QRCodeView.Delegate, EasyPermissions.PermissionCallbacks {
    private val REQUEST_CODE_QRCODE_PERMISSIONS = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_scan)
        scan_home_navigation.apply {
            btn_home.background = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
        }
        img_scan_back.setOnClickListener {
            onBackPressed()
        }
        zx_scan.setDelegate(this)
    }

    override fun onStart() {
        super.onStart()
        requestCodeQRCodePermissions()

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
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        vibrate()
        Log.d("scanResult", result)
        val intent = Intent(this,ScanNormal::class.java)
        intent.putExtra("title",result)
        startActivity(intent)
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
        Toast.makeText(this, "打开相机出错,检查相机权限.", Toast.LENGTH_LONG).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        zx_scan.startCamera() // 打开后置摄像头开始预览，但是并未开始识别
        //        mZXingView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT); // 打开前置摄像头开始预览，但是并未开始识别
        zx_scan.setType(BarcodeType.TWO_DIMENSION, null) // 只识别二维条码
        zx_scan.startSpotAndShowRect() // 显示扫描框，并开始识别
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
//        Toast.makeText(this,"扫码功能无法使用，请授予权限",Toast.LENGTH_LONG).show()
    }

//    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private fun requestCodeQRCodePermissions() {
        val perms = arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.READ_EXTERNAL_STORAGE)
        if (!EasyPermissions.hasPermissions(this, *perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, *perms)
        }
    }
}