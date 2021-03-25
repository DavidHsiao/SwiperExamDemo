package android.example.com.swiperexamdemo.wallet

import android.example.com.swiperexamdemo.R
import android.example.com.swiperexamdemo.databinding.FragmentWalletBinding
import android.example.com.swiperexamdemo.wallet.subFragVoucher.WalletVoucherFragment
import android.example.com.swiperexamdemo.wallet.subFragWallet.WalletCoinFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayoutMediator

class WalletFragment : Fragment() {

    private lateinit var binding:FragmentWalletBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWalletBinding.inflate(inflater)

        // 建立ViewModelFactory
        val viewModelFactory = WalletViewModelFactory()

        // 用ViewModelFactory建立ViewModel
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(WalletViewModel::class.java)

        // 設定ViewModel到Binding
        binding.viewModel = viewModel

        // 讓Data Binding依照Fragment的lifecycle來觀察LiveData
        binding.lifecycleOwner = this

        binding.viewPager2.adapter = WalletFragmentPagerAdapter(createFragList(), this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> tab.setText(R.string.coin_record)
                1 -> tab.text = getString(R.string.voucher)
//                1 -> tab.text = String.format(getString(R.string.voucher), data.voucherList.size)
                else -> {
                }
            }
        }.attach()

        return binding.root
    }

    private fun createFragList(): List<Fragment> {
        return mutableListOf(WalletCoinFragment(), WalletVoucherFragment())
    }

}