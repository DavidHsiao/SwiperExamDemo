package android.example.com.swiperexamdemo.wallet.subFragVoucher

import android.example.com.swiperexamdemo.data.DataStructure
import android.example.com.swiperexamdemo.wallet.subFragWallet.WalletCoinViewModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WalletVoucherViewModel : ViewModel() {
    private val TAG = WalletVoucherViewModel::class.java.simpleName

    // 用於儲存所有館別資訊
    private val _data = MutableLiveData<List<DataStructure>>()

    val data: MutableLiveData<List<DataStructure>>
        get() = _data

    init {
        getTaipeiZooArea()
    }

    private fun getTaipeiZooArea() {
        data.value = mutableListOf(
            DataStructure("兌換券A", 0),
            DataStructure("兌換券B", 1),
            DataStructure("兌換券C", 2),
            DataStructure("兌換券D", 3),
            DataStructure("兌換券E", 4),
            DataStructure("兌換券F", 5),
            DataStructure("兌換券G", 6),
            DataStructure("兌換券H", 7),
            DataStructure("兌換券I", 8),
            DataStructure("兌換券J", 9),
            DataStructure("兌換券K", 10),
            DataStructure("兌換券L", 11),
            DataStructure("兌換券M", 12),
            DataStructure("兌換券N", 13),
            DataStructure("兌換券O", 14),
            DataStructure("兌換券P", 15)
        )
    }

    // 當Fragment消失, ViewModel is destroyed, 因此Loading data的工作需要停止
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared()")
    }



}