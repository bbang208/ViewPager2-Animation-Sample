package io.github.bbang208.diffviewpager

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.github.bbang208.diffviewpager.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val list = listOf<Boolean>(true, true, false, true, false)

        viewBinding.pager.offscreenPageLimit = 3
        viewBinding.pager.setPageTransformer(ZoomOutPageTransformer())

        val pagerAdapter = ScreenSlidePagerAdapter(this, list)
        viewBinding.pager.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if (viewBinding.pager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewBinding.pager.currentItem = viewBinding.pager.currentItem - 1
        }
    }


    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity, val list: List<Boolean>) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = list.size

        override fun createFragment(position: Int): Fragment = CardFragment(list[position])
    }

}