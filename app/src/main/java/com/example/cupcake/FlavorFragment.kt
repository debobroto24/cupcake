package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentFlavorBinding


class FlavorFragment : Fragment() {

    private var binding: FragmentFlavorBinding? = null

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
            nextButton.setOnClickListener{goToNextScreen()}
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