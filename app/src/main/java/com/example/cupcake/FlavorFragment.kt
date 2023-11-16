package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentFlavorBinding
import com.example.cupcake.model.OrderViewModel


class FlavorFragment : Fragment() {

    private var binding: FragmentFlavorBinding? = null
    private val sharedViewModel : OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentFlavorBinding.inflate(inflater,container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel

//            nextButton.setOnClickListener{goToNextScreen()}
//            use listener binding to bind the button click listeners in the fragment classes to the layout.
            flavorFragment = this@FlavorFragment
        }
    }
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_flavorFragment2_to_pickupFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}