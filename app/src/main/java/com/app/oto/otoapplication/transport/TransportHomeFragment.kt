package com.app.oto.otoapplication.transport

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.CommonContext
import kotlinx.android.synthetic.main.home_fragment_transport.view.*


class TransportHomeFragment:Fragment() {

    companion object {
        fun newInstance(): TransportHomeFragment {
            return TransportHomeFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.home_fragment_transport,container,false)
        val cd_car = root.cd_car_fragment
        val cd_crowdsource = root.cd_crowdsource_fragment
        val cd_ordered = root.cd_ordered_fragment
        cd_car.setOnClickListener {
            startActivity(Intent(CommonContext.application, TransportCar::class.java))
        }
        cd_crowdsource.setOnClickListener {
            startActivity(Intent(CommonContext.application, TransportCrowdsource::class.java))
        }
        cd_ordered.setOnClickListener {
            startActivity(Intent(CommonContext.application, TransportOrdered::class.java))
        }
        return root
    }
}