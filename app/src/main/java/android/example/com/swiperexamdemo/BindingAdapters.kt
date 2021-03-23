package android.example.com.swiperexamdemo

import android.example.com.swiperexamdemo.data.DataStructure
import android.example.com.swiperexamdemo.wallet.subFragVoucher.WalletVoucherAdapter
import android.example.com.swiperexamdemo.wallet.subFragWallet.WalletCoinAdapter
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

// @BindingAdapter = 跟databinding說我要執行這項
// Bind OverviewFragment的RecyclerView Adapter
@BindingAdapter("listWallet")
fun bindCoinRecyclerView(recyclerView: RecyclerView, data: List<DataStructure>?) {
    val adapter = recyclerView.adapter as WalletCoinAdapter
    adapter.submitList(data)
}

@BindingAdapter("listVoucher")
fun bindVoucherRecyclerView(recyclerView: RecyclerView, data: List<DataStructure>?) {
    val adapter = recyclerView.adapter as WalletVoucherAdapter
    adapter.submitList(data)
}


