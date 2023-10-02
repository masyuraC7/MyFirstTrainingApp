package com.mc7.firstapptry.ui.homemenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mc7.firstapptry.R
import com.mc7.firstapptry.databinding.ActivityMoveForResultBinding

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMoveForResultBinding

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_choose -> {
                if (binding.rdGr.checkedRadioButtonId > 0){
                    var value = 0

                    when(binding.rdGr.checkedRadioButtonId){
                        R.id.rd_50 -> value = 50
                        R.id.rd_100 -> value = 100
                        R.id.rd_150 -> value = 150
                        R.id.rd_200 -> value = 200
                    }

                    val resultIntent = Intent()
                    resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                    setResult(RESULT_CODE, resultIntent)
                    finish()
                }
            }
        }
    }

}