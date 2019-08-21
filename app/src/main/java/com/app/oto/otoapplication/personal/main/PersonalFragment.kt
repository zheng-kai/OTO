package com.app.oto.otoapplication.personal.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.CommonContext
import com.app.oto.otoapplication.personal.base.getMyIntent
import com.app.oto.otoapplication.personal.face.FaceActivity
import com.app.oto.otoapplication.personal.friend.FriendActivity
import com.app.oto.otoapplication.personal.human.HumanActivity
import com.app.oto.otoapplication.personal.vehicle.VehicleActivity
import android.R.attr.fragment



class PersonalFragment: Fragment() {
    companion object {
        fun newInstance():PersonalFragment{
//            val fragment = Fragment1()
//            val bundle = Bundle()
//            bundle.putString(ARG_PARAM, str)
//            fragment.setArguments(bundle)
            return PersonalFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.home_personal_fragment,container,false)
        root.apply {
            findViewById<CardView>(R.id.verify_face_fragment).setOnClickListener {
                startActivity(getMyIntent(CommonContext.application, FaceActivity::class.java))
            }
            findViewById<CardView>(R.id.verify_vehicle_fragment).setOnClickListener {
                startActivity(getMyIntent(CommonContext.application, VehicleActivity::class.java))
            }
            findViewById<CardView>(R.id.verify_human_fragment).setOnClickListener {
                startActivity(getMyIntent(CommonContext.application, HumanActivity::class.java))
            }
            findViewById<CardView>(R.id.friend_fragment).setOnClickListener {
                startActivity(getMyIntent(CommonContext.application, FriendActivity::class.java))
            }
        }
        return root
    }
}