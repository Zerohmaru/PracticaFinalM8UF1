package com.practica.practicafinalm8uf1

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.practica.practicafinalm8uf1.Adapter.MyAdapter
import com.practica.practicafinalm8uf1.Common.Common
import com.practica.practicafinalm8uf1.Interface.RetrofitService
import com.practica.practicafinalm8uf1.Model.Marca
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : MyAdapter
    lateinit var dialog: AlertDialog

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        recyclerMarcas.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMarcas.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllList()
    }

    private fun getAllList() {
        dialog.show()

        mService.getModelList().enqueue(object : Callback<MutableList<Marca>> {
            override fun onFailure(call: Call<MutableList<Marca>>, t: Throwable) {
                var testNoUsado = 1
            }

            override fun onResponse(call: Call<MutableList<Marca>>, response: Response<MutableList<Marca>>) {
                adapter = MyAdapter(baseContext, response.body() as MutableList<Marca>)
                adapter.notifyDataSetChanged()
                recyclerMarcas.adapter = adapter

                dialog.dismiss()
            }

        })
    }
}