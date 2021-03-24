package android.example.com.swiperexamdemo.wallet.subFragWallet

import android.example.com.swiperexamdemo.common.ConstantValue.Companion.imgUrl
import android.example.com.swiperexamdemo.data.WalletDataStructure
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WalletCoinViewModel : ViewModel() {

    private val TAG = WalletCoinViewModel::class.java.simpleName

    // 用於儲存所有館別資訊
    private val _data = MutableLiveData<List<WalletDataStructure>>()

    val data: MutableLiveData<List<WalletDataStructure>>
        get() = _data

    init {
        getTaipeiZooArea()
    }

    private fun getTaipeiZooArea() {
        data.value = mutableListOf(WalletDataStructure("容幣A",imgUrl, 0), WalletDataStructure("容幣B",imgUrl, 1))
    }

    // 當Fragment消失, ViewModel is destroyed, 因此Loading data的工作需要停止
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared()")
    }


}