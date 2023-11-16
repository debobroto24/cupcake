package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentStartBinding
import com.example.cupcake.model.OrderViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class StartFragment : Fragment() {

    private  var binding : FragmentStartBinding? = null
    private val sharedViewModel : OrderViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding =  FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        apply all button together
//        binding?.apply {
//            orderOneCupcake.setOnClickListener { orderCupcake(1) }
//            orderSixCupcakes.setOnClickListener { orderCupcake(6) }
//            orderTwelveCupcakes.setOnClickListener { orderCupcake(12) }
//        }

        // using listener binding to bind the button click listeners in the fragment classes to the layout.
        binding?.startFragment = this

    }

     fun orderCupcake(quantity: Int) {
        sharedViewModel.setQuantity(quantity)
//        set the default flavor as Vanilla if no flavor is set
        if(sharedViewModel.hasNoFlavorSet()){
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }
      findNavController().navigate(R.id.action_startFragment_to_flavorFragment2)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}