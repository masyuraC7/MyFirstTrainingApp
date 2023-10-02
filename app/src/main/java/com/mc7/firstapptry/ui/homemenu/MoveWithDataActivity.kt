package com.mc7.firstapptry.ui.homemenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mc7.firstapptry.databinding.ActivityMoveWithDataBinding

class MoveWithDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoveWithDataBinding

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Name : $name, Age : $age"

        binding.dataReceived.text = text
    }
}