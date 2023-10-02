package com.mc7.firstapptry.ui.homemenu.fragmentactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mc7.firstapptry.R
import com.mc7.firstapptry.databinding.FragmentDetailCategoryBinding
import com.mc7.firstapptry.ui.homemenu.fragmentactivity.dialog.OptionDialogFragment

class DetailCategoryFragment : Fragment() {
    private lateinit var binding: FragmentDetailCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnProfile.setOnClickListener { v ->
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "Profile Fragment")
            mBundle.putString(EXTRA_DESCRIPTION, "Ini Halaman Profile")
            v.findNavController().navigate(
                R.id.action_detailCategoryFragment_to_profileActivity,
                mBundle)
        }

        binding.btnShowDialog.setOnClickListener{
            val optionDialogFragment = OptionDialogFragment()

            val fragmentManager = childFragmentManager
            optionDialogFragment.show(fragmentManager, OptionDialogFragment::class.java.simpleName)
        }

        // terima data lewat bundle
//        if (savedInstanceState != null) {
//            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
//            description = descFromBundle
//        }
//        if (arguments != null) {
//            val categoryName = arguments?.getString(EXTRA_NAME)
//            tvCategoryName.text = categoryName
//            tvCategoryDescription.text = description
//        }

        // terima data lewat nav argument
        val dataName = DetailCategoryFragmentArgs.fromBundle(
            arguments as Bundle
        ).name
        val dataStock = DetailCategoryFragmentArgs.fromBundle(
            arguments as Bundle
        ).stock

        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = "Stock : $dataStock"

        binding.btnBackHome.setOnClickListener{v ->
            v.findNavController().navigate(R.id.action_detailCategoryFragment_to_dashboardFragment)
        }
    }

    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener =
        object :
            OptionDialogFragment.OnOptionDialogListener {
        override fun onOptionChosen(text: String?) {
            Toast.makeText(requireActivity(), text, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }
}