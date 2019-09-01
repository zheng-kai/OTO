package com.app.oto.otoapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.app.oto.otoapplication.home.HomeFragment
import com.app.oto.otoapplication.personal.help.HelpActivity
import com.app.oto.otoapplication.personal.main.PersonalFragment
import com.app.oto.otoapplication.scan.ScanHome
import com.app.oto.otoapplication.scan.nomal_user.ScanNormal
import com.app.oto.otoapplication.transport.TransportHomeFragment
import kotlinx.android.synthetic.main.activity_oto.*
import kotlinx.android.synthetic.main.navigation_layout.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import org.jetbrains.anko.image

class OTOActivity : AppCompatActivity() {
    lateinit var help: TextView
    lateinit var scan: ImageView

    companion object {
        val INTENT_HOME_FLAG = "home"
        val INTENT_TRANSPORT_FLAG = "transport"
        val INTENT_PERSONAL_FLAG = "personal"
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntentData(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oto)
        setIntentData(intent)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        }
        help = tv_home_help.apply {
            setOnClickListener {
                startActivity(Intent(this@OTOActivity, HelpActivity::class.java))
            }
        }
        scan = img_home_scan.apply {
            setOnClickListener {
                startActivity(Intent(this@OTOActivity, ScanHome::class.java))
            }
        }

        scan.visibility = View.VISIBLE
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_home, HomeFragment.newInstance(), "fHome")
            .commit()
        transport_home_navigation.apply {
            // 初始化界面
            img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
            // 设置fragment跳转监听
            img_transport.setOnClickListener {
                replaceTransportFragment()
            }
            img_personal.setOnClickListener {
                replacePersonalFragment()
            }
            img_home.setOnClickListener {
                replaceHomeFragment()
            }
        }
    }

    private fun setIntentData(intent: Intent?) {
        when (intent?.getStringExtra("intentFlag")) {
            INTENT_HOME_FLAG -> replaceHomeFragment()
            INTENT_TRANSPORT_FLAG -> replaceTransportFragment()
            INTENT_PERSONAL_FLAG -> replacePersonalFragment()
        }
    }

    private fun replaceHomeFragment() {
        help.visibility = View.GONE
        scan.visibility = View.VISIBLE
        img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
        img_personal.image = ResourcesCompat.getDrawable(resources, R.mipmap.personal, null)
        img_transport.image = ResourcesCompat.getDrawable(resources, R.mipmap.transport, null)
        val fragment =
            this@OTOActivity.supportFragmentManager.findFragmentByTag("fHome")
                ?: HomeFragment.newInstance()

        this@OTOActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_home, fragment, "fHome")
            .commit()

    }

    private fun replacePersonalFragment() {
        help.visibility = View.VISIBLE
        img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home, null)
        img_personal.image = ResourcesCompat.getDrawable(resources, R.mipmap.personal_clicked, null)
        img_transport.image = ResourcesCompat.getDrawable(resources, R.mipmap.transport, null)
        val fragment =
            this@OTOActivity.supportFragmentManager.findFragmentByTag("fPersonal")
                ?: PersonalFragment.newInstance()

        this@OTOActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_home, fragment, "fPersonal")
            .commit()
    }

    private fun replaceTransportFragment() {
        help.visibility = View.GONE
        scan.visibility = View.GONE
        img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home, null)
        img_personal.image = ResourcesCompat.getDrawable(resources, R.mipmap.personal, null)
        img_transport.image = ResourcesCompat.getDrawable(resources, R.mipmap.transport_clicked, null)
        val fragment =
            this@OTOActivity.supportFragmentManager.findFragmentByTag("fTransport")
                ?: TransportHomeFragment.newInstance()

        this@OTOActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_home, fragment, "fTransport")
            .commit()

    }
}
