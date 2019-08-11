package com.app.oto.otoapplication.personal.help

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.app.oto.otoapplication.R

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personal_help_layout)
        setSupportActionBar(findViewById(R.id.personal_toolbar))
        supportActionBar?.title = "帮助"
    }
}
