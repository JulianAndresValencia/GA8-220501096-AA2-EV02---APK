package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Variables para los campos de entrada
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar las variables con los campos de entrada
        usernameEditText = findViewById(R.id.editTextUsername)
        passwordEditText = findViewById(R.id.editTextPassword)
    }

    // Función llamada cuando se hace clic en el botón de inicio de sesión
    fun onLogin(view: View) {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (validateCredentials(username, password)) {
            // Si las credenciales son correctas, muestra un mensaje de éxito
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            // Aquí puedes iniciar otra actividad si el inicio de sesión es exitoso
        } else {
            // Si las credenciales son incorrectas, muestra un mensaje de error
            Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para validar las credenciales (esto es solo un ejemplo)
    private fun validateCredentials(username: String, password: String): Boolean {
        // Puedes reemplazar esta lógica con la autenticación real
        return username == "usuario" && password == "contraseña"
    }
}
