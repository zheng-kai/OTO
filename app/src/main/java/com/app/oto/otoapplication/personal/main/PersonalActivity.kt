package com.app.oto.otoapplication.personal.main

import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.Menu
import android.view.MenuItem
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity
import com.app.oto.otoapplication.personal.base.getMyIntent
import com.app.oto.otoapplication.personal.face.FaceActivity
import com.app.oto.otoapplication.personal.friend.FriendActivity
import com.app.oto.otoapplication.personal.help.HelpActivity
import com.app.oto.otoapplication.personal.human.HumanActivity
import com.app.oto.otoapplication.personal.vehicle.VehicleActivity

class PersonalActivity : BaseActivity(), MainContract.View {
    override fun initToolbar() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.home_personal_layout)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        findViewById<CardView>(R.id.verify_face).setOnClickListener {
            startActivity(getMyIntent(this, FaceActivity::class.java))
        }
        findViewById<CardView>(R.id.verify_vehicle).setOnClickListener {
            startActivity(getMyIntent(this, VehicleActivity::class.java))
        }
        findViewById<CardView>(R.id.verify_human).setOnClickListener {
            startActivity(getMyIntent(this, HumanActivity::class.java))
        }
        findViewById<CardView>(R.id.friend).setOnClickListener {
            startActivity(getMyIntent(this, FriendActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.personal_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.help -> {
            startActivity(getMyIntent(this, HelpActivity::class.java))
            true
        }
        else -> false
    }
}
