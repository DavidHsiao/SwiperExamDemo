package android.example.com.swiperexamdemo.wallet

import android.example.com.swiperexamdemo.wallet.subFragWallet.WalletCoinFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class WalletFragmentPagerAdapter(private val fragList: List<Fragment>, parent: Fragment) : FragmentStateAdapter(parent){
    override fun getItemCount(): Int {
        return fragList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragList[position]
    }
}