package android.example.com.swiperexamdemo.wallet.subFragWallet

import android.example.com.swiperexamdemo.databinding.FragmentWalletPagerCoinBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class WalletCoinFragment : Fragment() {

    private val mAdapter = WalletCoinAdapter()

    /**
     * Lazily initialize our [OverviewViewModel].
     */
    private val viewModel: WalletCoinViewModel by lazy {
        ViewModelProviders.of(this).get(WalletCoinViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


//        return inflater.inflate(R.layout.fragment_wallet_pager_coin, container, false)
        val binding = FragmentWalletPagerCoinBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        binding.rvCoin.adapter = mAdapter
//        mAdapter.setData(mutableListOf(Reward("容畢A", 0), Reward("容畢B", 1)))

        return binding.root
    }


}