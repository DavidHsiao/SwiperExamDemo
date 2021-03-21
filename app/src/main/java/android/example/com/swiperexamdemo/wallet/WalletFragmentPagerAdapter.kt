package android.example.com.swiperexamdemo.wallet

import android.example.com.swiperexamdemo.wallet.subFragment.WalletPagerFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class WalletFragmentPagerAdapter(fa: Fragment) : FragmentStateAdapter(fa){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return WalletPagerFragment()
    }
}