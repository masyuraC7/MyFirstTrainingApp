package com.mc7.firstapptry.ui.homemenu.fragmentactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.mc7.firstapptry.R
import com.mc7.firstapptry.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategory.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_dashboardFragment_to_categoryFragment)
        )
        binding.btnProfile.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_dashboardFragment_to_profileActivity)
        }
    }

    // manual move fragment
//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.btn_category -> {
//                val categoryFragment = CategoryFragment()
//                val fragmentManager = parentFragmentManager
//                fragmentManager.beginTransaction().apply {
////                    replace(R.id.frame_container, categoryFragment, CategoryFragment::class.java.simpleName)
//                    //backstack for save instate(menyimpan fragment sebelumnya)
//                    addToBackStack(null)
//                    commit()
//                }
//            }
//        }
//    }
}