package com.app.oto.otoapplication.transport

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.transport_car.*

class TransportCar:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transport_car)
        img_car_back.setOnClickListener {
            onBackPressed()
        }
        map_transport_car
    }

    override fun onResume() {
        super.onResume()
        map_transport_car.onResume()
    }

    override fun onPause() {
        super.onPause()
        map_transport_car.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        map_transport_car.onDestroy()
    }
}