package android.example.com.swiperexamdemo.wallet.subFragVoucher

import android.example.com.swiperexamdemo.databinding.FragmentWalletPagerCoinBinding
import android.example.com.swiperexamdemo.databinding.FragmentWalletPagerVoucherBinding
import android.example.com.swiperexamdemo.wallet.subFragWallet.WalletCoinAdapter
import android.example.com.swiperexamdemo.wallet.subFragWallet.WalletCoinViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class WalletVoucherFragment : Fragment() {
    private val mAdapter = WalletVoucherAdapter()

    /**
     * Lazily initialize our [OverviewViewModel].
     */
    private val viewModel: WalletVoucherViewModel by lazy {
        ViewModelProviders.of(this).get(WalletVoucherViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        //        return inflater.inflate(R.layout.fragment_wallet_pager_coin, container, false)
        val binding = FragmentWalletPagerVoucherBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        binding.rvVoucher.adapter = mAdapter

        return binding.root
    }
}