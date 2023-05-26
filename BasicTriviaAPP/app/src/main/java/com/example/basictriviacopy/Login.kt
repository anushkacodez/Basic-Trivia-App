package com.example.basictriviacopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basictriviacopy.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)


        binding= ActivityLoginBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.startButton.setOnClickListener {
                val intent = Intent(this@Login, ChooseDifficulty::class.java)
                startActivity(intent)
        }
    }
}