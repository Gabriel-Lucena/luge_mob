package com.example.luge

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.luge.api.Endpoint
import com.example.luge.util.NetworkUtils
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : ComponentActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById<EditText>(R.id.username)
        password = findViewById<EditText>(R.id.password)

        val login_button = findViewById<Button>(R.id.login)

        login_button.setOnClickListener { }
    }

    fun login(username: String, password: String) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("http://192.168.0.183:3000/")

        val endpoint = retrofitClient.create(Endpoint::class.java)

        // montar o json

        val body = mapOf(
            "username" to username,
            "password" to password
        )

        val callback = endpoint.login(body)

        callback.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                println(t.message)
            }
        })

    }
}