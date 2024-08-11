package com.example.myapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.network.ApiClient
import com.example.myapp.network.ApiService
import com.example.myapp.network.Response
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextCedula: EditText
    private lateinit var editTextCountry: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextId: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextCedula = findViewById(R.id.editTextCedula)
        editTextCountry = findViewById(R.id.editTextCountry)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextId = findViewById(R.id.editTextId)
    }

    fun onCreateUser(view: View) {
        val name = editTextName.text.toString()
        val cedula = editTextCedula.text.toString()
        val country = editTextCountry.text.toString()
        val email = editTextEmail.text.toString()

        val apiService = ApiClient.getClient().create(ApiService::class.java)
        val call = apiService.manageUser("create", "", name, cedula, country, email, "", "")
        call.enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.body()?.status == "success") {
                    Toast.makeText(this@MainActivity, "User created successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun onUpdateUser(view: View) {
        val id = editTextId.text.toString()
        val name = editTextName.text.toString()
        val cedula = editTextCedula.text.toString()
        val country = editTextCountry.text.toString()
        val email = editTextEmail.text.toString()

        val apiService = ApiClient.getClient().create(ApiService::class.java)
        val call = apiService.manageUser("update", id, name, cedula, country, email, "", "")
        call.enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.body()?.status == "success") {
                    Toast.makeText(this@MainActivity, "User updated successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun onDeleteUser(view: View) {
        val id = editTextId.text.toString()

        val apiService = ApiClient.getClient().create(ApiService::class.java)
        val call = apiService.manageUser("delete", id, "", "", "", "", "", "")
        call.enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if (response.body()?.status == "success") {
                    Toast.makeText(this@MainActivity, "User deleted successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
