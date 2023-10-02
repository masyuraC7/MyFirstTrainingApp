package com.mc7.firstapptry.ui.homemenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mc7.firstapptry.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        supportActionBar?.title = "Latihan Fragment"

        // manual move fragment
//        val fragmentManager = supportFragmentManager
//        val homeFragment = HomeFragments()
//        val fragment = fragmentManager.findFragmentByTag(HomeFragments::class.java.simpleName)

//        if (fragment !is HomeFragments) {
//            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragments::class.java.simpleName)
//            fragmentManager
//                .beginTransaction()
//                .add(R.id.frame_container, homeFragment, HomeFragments::class.java.simpleName)
//                .commit()
//        }
    }
}