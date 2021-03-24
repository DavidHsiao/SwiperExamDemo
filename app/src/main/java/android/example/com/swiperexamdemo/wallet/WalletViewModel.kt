package android.example.com.swiperexamdemo.wallet

import android.example.com.swiperexamdemo.common.ConstantValue.Companion.imgUrl
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WalletViewModel : ViewModel() {

    private val TAG = this::class.java.simpleName

    // 用於儲存所有館別資訊
    private val _iconUrl = MutableLiveData<String>()

    val iconUrl: MutableLiveData<String>
        get() = _iconUrl

    init {
        // StarBucks Icon
        _iconUrl.value = imgUrl
    }

}