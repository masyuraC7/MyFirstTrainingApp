package com.mc7.firstapptry.ui.homemenu.fragmentactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mc7.firstapptry.databinding.ActivityMenuProfileBinding

class MenuProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    searchBar.text = searchView.text
                    searchView.hide()
                    Toast.makeText(this@MenuProfileActivity, searchView.text, Toast.LENGTH_SHORT)
                        .show()
                    false
                }
        }
    }
}