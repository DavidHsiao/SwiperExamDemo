package android.example.com.swiperexamdemo.wallet.subFragVoucher

import android.example.com.swiperexamdemo.data.VoucherDataStructure
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WalletVoucherViewModel : ViewModel() {
    private val TAG = WalletVoucherViewModel::class.java.simpleName

    // 用於儲存所有館別資訊
    private val _data = MutableLiveData<List<VoucherDataStructure>>()

    val data: MutableLiveData<List<VoucherDataStructure>>
        get() = _data

    init {
        setVoucherData()
    }

    private fun setVoucherData() {
        data.value = mutableListOf(
            VoucherDataStructure("兌換券A", 0),
            VoucherDataStructure("兌換券B", 1),
            VoucherDataStructure("兌換券C", 2),
            VoucherDataStructure("兌換券D", 3),
            VoucherDataStructure("兌換券E", 4),
            VoucherDataStructure("兌換券F", 5),
            VoucherDataStructure("兌換券G", 6),
            VoucherDataStructure("兌換券H", 7),
            VoucherDataStructure("兌換券I", 8),
            VoucherDataStructure("兌換券J", 9),
            VoucherDataStructure("兌換券K", 10),
            VoucherDataStructure("兌換券L", 11),
            VoucherDataStructure("兌換券M", 12),
            VoucherDataStructure("兌換券N", 13),
            VoucherDataStructure("兌換券O", 14),
            VoucherDataStructure("兌換券P", 15)
        )
    }

    // 當Fragment消失, ViewModel is destroyed, 因此Loading data的工作需要停止
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared()")
    }



}