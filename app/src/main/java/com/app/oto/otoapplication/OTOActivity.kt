package com.app.oto.otoapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.app.oto.otoapplication.personal.help.HelpActivity
import com.app.oto.otoapplication.personal.main.PersonalFragment
import com.app.oto.otoapplication.scan.nomal_user.ScanNormal
import com.app.oto.otoapplication.transport.TransportHomeFragment
import kotlinx.android.synthetic.main.activity_oto.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import org.jetbrains.anko.image

class OTOActivity : AppCompatActivity() {
    lateinit var help: TextView
    lateinit var img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oto)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

//        }
        help = tv_home_help.apply {
            setOnClickListener {
                startActivity(Intent(this@OTOActivity, HelpActivity::class.java))
            }
        }
        img = img_home_scan.apply {
            setOnClickListener {
                startActivity(Intent(this@OTOActivity, ScanNormal::class.java))
            }
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_home, TransportHomeFragment.newInstance(), "fTransport")
            .commit()
        transport_home_navigation.apply {
            img_transport.image = ResourcesCompat.getDrawable(resources, R.mipmap.transport_clicked, null)
            img_transport.setOnClickListener {
                help.visibility = View.GONE
                img.visibility = View.GONE
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
            img_personal.setOnClickListener {
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
        }
    }
}
