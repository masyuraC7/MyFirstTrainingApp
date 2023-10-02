package com.mc7.firstapptry.ui.homemenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.mc7.firstapptry.data.local.entity.Person
import com.mc7.firstapptry.ui.homemenu.fragmentactivity.ProfileActivity
import com.mc7.firstapptry.R
import com.mc7.firstapptry.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null){
            val selectedValue =
                result.data?.getIntExtra(
                    MoveForResultActivity.EXTRA_SELECTED_VALUE, 0
                )

            Toast.makeText(requireActivity(), "Hasil : $selectedValue", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAritmatika.setOnClickListener(this)
        binding.btnNext.setOnClickListener(this)
        binding.btnNextWithData.setOnClickListener(this)
        binding.btnNextWithObject.setOnClickListener(this)
        binding.btnDialNumber.setOnClickListener(this)
        binding.btnMoveForResult.setOnClickListener(this)
        binding.btnMoveToViewViewGroup.setOnClickListener(this)
        binding.btnMoveToRecyclerView.setOnClickListener(this)
        binding.btnFragment.setOnClickListener(this)
        binding.btnTopAppBar.setOnClickListener(this)
        binding.btnBottomNavigation.setOnClickListener(this)
        binding.btnTabLayout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_aritmatika -> {
                val intentToAritmatikaFragment = Intent(requireActivity(), AritmatikaActivity::class.java)
                startActivity(intentToAritmatikaFragment)
            }

            R.id.btn_next -> {
                val moveIntent = Intent(requireActivity(), MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_nextWithData -> {
                val moveWithDataIntent = Intent(requireActivity(),
                    MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(
                    MoveWithDataActivity.EXTRA_NAME,
                    "Dicoding Academy Boyyy!")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 21)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_nextWithObject -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )

                val moveWithObjectIntent = Intent(requireActivity(),
                    MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dialNumber -> {
                val phoneNumber = "088765339834"
                val dialPhoneIntent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_moveForResult -> {
                val moveForResultIntent = Intent(requireActivity(),
                    MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }

            R.id.btn_move_to_view_view_group -> {
                val moveToNewPageIntent = Intent(requireActivity(),
                    ViewAndViewGroupActivity::class.java)
                startActivity(moveToNewPageIntent)
            }

            R.id.btn_moveToRecyclerView -> {
                val moveToRecyclerViewIntent = Intent(requireActivity(),
                    RecyclerViewActivity::class.java)
                startActivity(moveToRecyclerViewIntent)
            }

            R.id.btn_fragment -> {
                val moveToFragmentIntent = Intent(requireActivity(),
                    FragmentActivity::class.java)
                startActivity(moveToFragmentIntent)
            }

            R.id.btn_topAppBar -> {
                val moveToProfileIntent = Intent(requireActivity(),
                    ProfileActivity::class.java)
                startActivity(moveToProfileIntent)
            }

            R.id.btn_bottom_navigation -> {
                val toBottomNavigationActivity = Intent(requireActivity(),
                    BottomNavigationActivity::class.java)
                startActivity(toBottomNavigationActivity)
            }

            R.id.btn_tab_layout -> {
                val moveToTabLayoutIntent = Intent(requireActivity(),
                    TabLayoutActivity::class.java)
                startActivity(moveToTabLayoutIntent)
            }
        }
    }
}