package com.example.basictriviacopy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basictriviacopy.databinding.ActivityChooseDifficultyBinding


class ChooseDifficulty : AppCompatActivity() {
    private lateinit var binding: ActivityChooseDifficultyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)


        binding= ActivityChooseDifficultyBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.easy.setOnClickListener {
            val intent = Intent(this@ChooseDifficulty, ChooseCategory::class.java)
            startActivity(intent)
        }

        binding.difficult.setOnClickListener {
            val intent = Intent(this@ChooseDifficulty, ChooseCategoryDiff::class.java)
            startActivity(intent)
        }
    }
}