package android.example.com.swiperexamdemo.wallet.subFragment

import android.example.com.swiperexamdemo.data.Reward
import android.example.com.swiperexamdemo.databinding.FragmentWalletPagerCoinBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class WalletPagerFragment : Fragment(){

    // 用於儲存所有館別資訊
    private val _data = MutableLiveData<List<Reward>>()

    private val mAdapter = WalletPagerAdapter()

    val data: LiveData<List<Reward>>
        get() = _data

    override fun onResume() {
        super.onResume()

        _data.value = mutableListOf(Reward("Q", 1.0,0), Reward("Z", 1.0,1))
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_wallet_pager_coin, container, false)
        val binding = FragmentWalletPagerCoinBinding.inflate(inflater)

        binding.recyclerView.adapter = mAdapter

        mAdapter.setData(mutableListOf(Reward("Q", 1.0,0), Reward("Z", 1.0,1)))

        return binding.root
    }
}