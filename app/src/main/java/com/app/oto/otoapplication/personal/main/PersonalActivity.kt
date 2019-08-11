package com.app.oto.otoapplication.personal.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.personal.base.BaseActivity
import com.app.oto.otoapplication.personal.base.test

class PersonalActivity : BaseActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.home_personal_layout)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.personal_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.help -> {

            true
        }
        else -> false
    }
}
