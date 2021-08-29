package io.github.bbang208.diffviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.bbang208.diffviewpager.databinding.FragmentCardType1Binding
import io.github.bbang208.diffviewpager.databinding.FragmentCardType2Binding

class CardFragment(private val type: Boolean) : Fragment() {
    private lateinit var cardType1Binding: FragmentCardType1Binding
    private lateinit var cardType2Binding: FragmentCardType2Binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = if (type) {
        cardType1Binding = FragmentCardType1Binding.inflate(
            layoutInflater,
            container,
            false
        )
        cardType1Binding.root
    } else {
        cardType2Binding = FragmentCardType2Binding.inflate(layoutInflater, container, false)
        cardType2Binding.root
    }


}