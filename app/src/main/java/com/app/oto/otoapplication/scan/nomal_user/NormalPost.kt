package com.app.oto.otoapplication.scan.nomal_user

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import cn.edu.twt.retrox.recyclerviewdsl.withItems
import com.alibaba.fastjson.JSON
import com.app.oto.otoapplication.R
import com.app.oto.otoapplication.commons.setNavigationClickListener
import com.app.oto.otoapplication.scan.add
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.scan_result_normal_post.*
import org.jetbrains.anko.image
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class NormalPost : AppCompatActivity() {
    /** 所有省 */
    lateinit var provinceDatas: List<ProvinceEntity>
    /** 所有市  */
    lateinit var cityDatas: List<CityEntity>
    /** 所有区  */
    lateinit var districtDatas: List<DistrictEntity>
    /** 当前省下显示市  */
    private val currentCitiesDatas = ArrayList<CityEntity>()
    /** 当前市下显示县  */
    private val currentDistrictsDatas = ArrayList<DistrictEntity>()
    /** 省截取2位代码  */
    private var provinceChargeCode: String? = null
    /** 市截取2位代码  */
    private var cityChargeCode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_result_normal_post)
        val anim = AnimationUtils.loadAnimation(this, R.anim.dialog_top_in)
        scan_normal_post_navigation.apply {
            img_home.image = ResourcesCompat.getDrawable(resources, R.mipmap.home_clicked, null)
            setNavigationClickListener(this@NormalPost)
        }
        img_post_back.setOnClickListener {
            onBackPressed()
        }
        rec_normal_post.layoutManager = LinearLayoutManager(this)
        rec_normal_post.withItems {
            for (i in 1..3) {
                add("Jack", "12345678910", "xxxxxxxxxxx") {
                    frame_normal_post_dialog.animation = anim
                    frame_normal_post_dialog.visibility = View.VISIBLE
                }
            }
        }
        btn_normal_custom_post.setOnClickListener {
            frame_normal_post_dialog.animation = anim
            frame_normal_post_dialog.visibility = View.VISIBLE
        }
        frame_normal_post_dialog.setOnClickListener {
            frame_normal_post_dialog.visibility = View.GONE
            startActivity(Intent(this, NormalPostPay::class.java))
        }
        parseArray()

        selectProvince()
    }

    private fun selectProvince() {
        val provinceAdapter = SpinnerAdapter()
        val data = ArrayList<String>().apply {
            provinceDatas.forEach {
                it.text?.let { text ->
                    add(text)
                }

            }
        }
        provinceAdapter.setData(data)
        spinner_province.adapter = provinceAdapter
        spinner_province.setSelection(0)
        spinner_province.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                provinceChargeCode = provinceDatas[position].id?.subSequence(0, 2).toString()
                cityDatas.forEach {
                    if (it.id?.subSequence(0, 2).toString() == provinceChargeCode) {
                        currentCitiesDatas.add(it)
                    }
                }
                selectCity()
            }

        }
//        spinner_province.setOnItemClickListener { parent, view, position, id ->
//            provinceChargeCode = provinceDatas[position].id?.subSequence(0, 2).toString()
//            cityDatas.forEach {
//                if (it.id?.subSequence(0, 2).toString() == provinceChargeCode) {
//                    currentCitiesDatas.add(it)
//                }
//            }
//            selectCity()
//        }
    }

    private fun selectCity() {
        val cityAdapter = SpinnerAdapter()
        val data = ArrayList<String>().apply {
            currentCitiesDatas.forEach {
                it.text?.let { text ->
                    add(text)
                }
            }
        }
        cityAdapter.setData(data)
        spinner_city.adapter = cityAdapter
        spinner_city.setSelection(0)
        spinner_city.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                cityChargeCode = currentCitiesDatas[position].id?.subSequence(0, 2).toString()
                districtDatas.forEach {
                    if (it.id?.subSequence(0, 2).toString() == cityChargeCode) {
                        currentDistrictsDatas.add(it)
                    }
                }
                selectDistrict()
            }

        }

//        spinner_city.setOnItemClickListener { parent, view, position, id ->
//            cityChargeCode = currentCitiesDatas[position].id?.subSequence(0, 2).toString()
//            districtDatas.forEach {
//                if (it.id?.subSequence(0, 2).toString() == cityChargeCode) {
//                    currentDistrictsDatas.add(it)
//                }
//            }
//            selectDistrict()
//        }
    }

    private fun selectDistrict() {
        val districtAdapter = SpinnerAdapter()
        val data = ArrayList<String>().apply {
            currentDistrictsDatas.forEach {
                it.text?.let { text ->
                    add(text)
                }
            }
        }
        districtAdapter.setData(data)
        spinner_district.adapter = districtAdapter
        spinner_district.setSelection(0)

    }

    /**
     * 解析出所有省市县
     */
    private fun parseArray() {
        try {
            val jObject = JSONObject(getAddress())
            val provinceArray = jObject.getJSONArray("province")
            val cityArray = jObject.getJSONArray("city")
            val countyArray = jObject.getJSONArray("district")
            provinceDatas = JSON.parseArray(provinceArray.toString(), ProvinceEntity::class.java)
            cityDatas = JSON.parseArray(cityArray.toString(), CityEntity::class.java)
            districtDatas = JSON.parseArray(countyArray.toString(), DistrictEntity::class.java)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    /**
     * 从资源文件中获取json字符串
     *
     * @return
     */
    private fun getAddress(): String {
        val sb = StringBuilder()
        try {
            val inputStream = resources.openRawResource(R.raw.area)
            val buffer = ByteArray(1024)
            while (inputStream.read(buffer) != -1) {
                sb.append(String(buffer, Charsets.UTF_8))
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return sb.toString()
    }
}