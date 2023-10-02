package com.mc7.firstapptry.ui.homemenu.fragmentactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mc7.firstapptry.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment(){
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDetailCategory.setOnClickListener { v ->
            val toDetailCategoryFragment =
                CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailCategoryFragment.name = "Lifestyle"
            toDetailCategoryFragment.stock = 7
            v.findNavController().navigate(toDetailCategoryFragment)
        }
    }

    // manual move with fragmentmanager
//    override fun onClick(v: View?) {
//        when(v?.id) {
//            R.id.btn_detail_category -> {
//                val detailCategoryFragment = DetailCategoryFragment()
//                val bundle = Bundle()
//
//                bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
//
//                val description = "Kategori ini akan berisi produk-produk lifestyle"
//
//                detailCategoryFragment.arguments = bundle
//                detailCategoryFragment.description = description
//                val fragmentManager = parentFragmentManager
//
//                fragmentManager.beginTransaction().apply {
//                    replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
//                    addToBackStack(null)
//                    commit()
//                }
//            }
//        }
//    }
}