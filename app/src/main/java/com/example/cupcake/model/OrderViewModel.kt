package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*
private  const val PRICE_PER_CAKE = 2.00
private  const val PRICE_FOR_SAME_DAY_PICKUP = 3.00
class OrderViewModel : ViewModel() {


    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>()
    val flavor : LiveData<String> = _flavor

    private val _date = MutableLiveData<String>()
    val date : LiveData<String> = _date

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price

    val dateOptions = getPickupOptions()
    val dd : String = dateOptions[0]

    init {
        resetOrder()
    }

    fun setQuantity(numberOfCupcake : Int){
        _quantity.value = numberOfCupcake
        updatePrice()
    }

    fun setFlavor(desireFlavor : String) {
        _flavor.value = desireFlavor
    }

    fun setDate(pickupDate : String){
       _date.value = pickupDate
        updatePrice()
    }

    fun hasNoFlavorSet() : Boolean{
        return flavor.value.isNullOrEmpty()
    }


    private fun getPickupOptions() : List<String>{

        val options = mutableListOf<String>()
       val formatter =  SimpleDateFormat("E MMM D", Locale.getDefault())
        val calender =  Calendar.getInstance()
        // create a list of dates starting with the current date and following current date
        repeat(4){
            options.add(formatter.format(calender.time))
            calender.add(Calendar.DATE, 1)
        }
        return options
    }

    private fun updatePrice(){
        var calculatePrice = PRICE_PER_CAKE * (quantity.value ?: 0)
        if(dateOptions[0] == date.value){
            calculatePrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        _price.value = calculatePrice
    }

    fun resetOrder(){
        _price.value = 0.0
        _flavor.value ="0"
        _date.value = dateOptions[0]
        _quantity.value = 0
    }





}