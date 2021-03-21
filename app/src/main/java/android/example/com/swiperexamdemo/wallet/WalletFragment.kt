package android.example.com.swiperexamdemo.wallet

import android.example.com.swiperexamdemo.databinding.FragmentWalletBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

class WalletFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWalletBinding.inflate(inflater)

        // 建立ViewModelFactory
        val viewModelFactory = WalletViewModelFactory()

        // 用ViewModelFactory建立ViewModel
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(WalletViewModel::class.java)

        // 設定ViewModel到Binding
        binding.viewModel = viewModel

        // 讓Data Binding依照Fragment的lifecycle來觀察LiveData
        binding.lifecycleOwner = this

        binding.viewPager2.adapter = WalletFragmentPagerAdapter(this)

        return binding.root
    }
}