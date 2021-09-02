package io.github.bbang208.diffviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.bbang208.diffviewpager.databinding.FragmentCardType1Binding
import io.github.bbang208.diffviewpager.databinding.FragmentCardType2Binding

class CardFragment : Fragment() {

    companion object {
        private const val KEY = "type"

        fun newInstance(type: Boolean) = CardFragment().apply {
            arguments = Bundle().apply {
                putBoolean(KEY, type)
            }
        }
    }

    private lateinit var cardType1Binding: FragmentCardType1Binding
    private lateinit var cardType2Binding: FragmentCardType2Binding

    private val type by lazy { requireArguments().getBoolean(KEY) }

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