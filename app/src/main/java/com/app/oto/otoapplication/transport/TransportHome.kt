package com.app.oto.otoapplication.transport

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.home_activity_transport.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import pub.devrel.easypermissions.EasyPermissions

class TransportHome : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    private val REQUEST_CODE_GPS_PERMISSIONS = 1

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>?) {
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>?) {
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_transport)
        transport_home_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources, R.mipmap.transport_clicked, null)
        }
        cd_car.setOnClickListener {
            startActivity(Intent(this, TransportCar::class.java))
        }
        cd_crowdsource.setOnClickListener {
            startActivity(Intent(this, TransportCrowdsource::class.java))
        }
        cd_ordered.setOnClickListener {
            startActivity(Intent(this, TransportOrdered::class.java))
        }
        requestCodeGPSPermissions()
    }

    private fun requestCodeGPSPermissions() {
        val perms = arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
        if (!EasyPermissions.hasPermissions(this, *perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_GPS_PERMISSIONS, *perms)
        }
    }
}