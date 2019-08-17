package com.app.oto.otoapplication.scan.nomal_user

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.scan.add
import kotlinx.android.synthetic.main.scan_result_normal_post.*

class NormalPost:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_normal_post)
        rec_normal_post.layoutManager = LinearLayoutManager(this)
        rec_normal_post.withItems {
            for(i in 1..3){
                add("Jack","12345678910","xxxxxxxxxxx")
            }
        }
        btn_normal_custom_post.setOnClickListener {

        }

    }
}