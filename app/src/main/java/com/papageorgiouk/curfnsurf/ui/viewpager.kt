package com.papageorgiouk.curfnsurf.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.papageorgiouk.curfnsurf.ui.form.id.IdFragment
import com.papageorgiouk.curfnsurf.ui.form.postcode.PostCodeFragment
import com.papageorgiouk.curfnsurf.ui.form.purpose.PurposeFragment

class FormFragmentsAdapter(fm: FragmentManager, lifecycle: Lifecycle, val onNext: (() -> Unit)) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PurposeFragment(onNext)
            1 -> IdFragment(onNext)
            2 -> PostCodeFragment(onNext)
            else -> throw IllegalStateException("Invalid viewpager position")
        }
    }

}

fun ViewPager2.hasBackStack() = this.currentItem > 0

fun ViewPager2.popBackStack() {
    this.currentItem = this.currentItem - 1
}
