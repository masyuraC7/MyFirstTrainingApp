package com.mc7.firstapptry.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mc7.firstapptry.R
import com.mc7.firstapptry.data.local.entity.Hero
import com.mc7.firstapptry.databinding.ActivityDetailHeroBinding

class DetailHeroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra<Hero>("Hero") as Hero

        with(binding){
            Glide.with(applicationContext)
                .load(hero.photo)
                .circleCrop()
                .into(profileImageView)
            nameTextView.text = hero.name
            descTextView.text = hero.description
        }
    }
}