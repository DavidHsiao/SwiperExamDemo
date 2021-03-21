package android.example.com.swiperexamdemo.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WalletViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WalletViewModel::class.java)) {
            return WalletViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}