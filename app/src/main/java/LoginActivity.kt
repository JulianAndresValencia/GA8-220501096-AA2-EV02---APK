package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.network.ApiClient
import com.example.myapp.network.ApiService
import com.example.myapplication.R
import com.example.myapp.network.Response as ApiResponse // Renombrar la importación para evitar conflicto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun onLogin(view: View) {
        val username = editTextUsername.text.toString()
        val password = editTextPassword.text.toString()

        val apiService = ApiClient.getClient().create(ApiService::class.java)
        val call = apiService.login(username, password)
        call.enqueue(object : Callback<ApiResponse> { // Usar el nombre renombrado aquí
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.body()?.status == "success") {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
