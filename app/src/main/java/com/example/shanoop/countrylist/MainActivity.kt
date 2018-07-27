package com.example.shanoop.countrylist

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    val data= ArrayList<Country>()
    var context: Context? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context=this
        doAsync {
            val resp=URL("http://services.groupkt.com/country/get/all").readText()
            val result=JSONObject(resp).optJSONObject("RestResponse").optJSONArray("result")

            makeCountryData(result)
            uiThread {
                countryRecyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                val adapter=CountryAdapter(data)
                countryRecyclerView.adapter=adapter
            }
        }
    }


    fun makeCountryData(countries:JSONArray)
    {
        for (i in 0..countries.length()-1) {
            val tmp=countries.getJSONObject(i)
            data.add(Country(tmp.optString("name"),tmp.optString("alpha2_code"),tmp.optString("alpha3_code")))
        }
    }
}
