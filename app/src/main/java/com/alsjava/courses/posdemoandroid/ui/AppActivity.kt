package com.alsjava.courses.posdemoandroid.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alsjava.courses.posdemoandroid.R
import com.alsjava.courses.posdemoandroid.model.adapters.ProductAdapter
import com.alsjava.courses.posdemoandroid.model.communication.request.ProductRequest
import com.alsjava.courses.posdemoandroid.utils.ServiceTool
import kotlinx.android.synthetic.main.activity_app.*

class AppActivity : AppCompatActivity() {

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)

        productAdapter = ProductAdapter(this)
        rvProducts.layoutManager = LinearLayoutManager(this)
        rvProducts.adapter = productAdapter
        rvProducts.addItemDecoration(
                DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )

        ServiceTool.get().products(ProductRequest()) {
            productAdapter.loadData(it?.products)
            runOnUiThread {
                productAdapter.notifyDataSetChanged()
            }
        }
    }
}
