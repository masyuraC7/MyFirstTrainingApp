package com.mc7.firstapptry.ui.homemenu

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mc7.firstapptry.data.local.entity.Person
import com.mc7.firstapptry.databinding.ActivityMoveWithObjectBinding

class MoveWithObjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoveWithObjectBinding

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveWithObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        if (person != null){
            val text = "Name : ${person.name} \nAge : ${person.age}" +
                    "\nEmail : ${person.email} \nCity : ${person.city}"
            binding.objectReceived.text = text
        }
    }
}