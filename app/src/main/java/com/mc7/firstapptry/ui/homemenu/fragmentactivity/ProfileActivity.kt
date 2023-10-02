package com.mc7.firstapptry.ui.homemenu.fragmentactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mc7.firstapptry.R
import com.mc7.firstapptry.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.showArticles -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MenuProfileFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.searchViewProfile -> {
                    val intent = Intent(this, MenuProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}