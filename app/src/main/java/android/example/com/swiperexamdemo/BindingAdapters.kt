package android.example.com.swiperexamdemo

import android.example.com.swiperexamdemo.data.VoucherDataStructure
import android.example.com.swiperexamdemo.data.WalletDataStructure
import android.example.com.swiperexamdemo.wallet.subFragVoucher.WalletVoucherAdapter
import android.example.com.swiperexamdemo.wallet.subFragWallet.WalletCoinAdapter
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

// @BindingAdapter = 跟databinding說我要執行這項
// Bind OverviewFragment的RecyclerView Adapter
@BindingAdapter("listWallet")
fun bindCoinRecyclerView(recyclerView: RecyclerView, data: List<WalletDataStructure>?) {
    val adapter = recyclerView.adapter as WalletCoinAdapter
    adapter.submitList(data)
}

@BindingAdapter("listVoucher")
fun bindVoucherRecyclerView(recyclerView: RecyclerView, data: List<VoucherDataStructure>?) {
    val adapter = recyclerView.adapter as WalletVoucherAdapter
    adapter.submitList(data)
}

// 使用Glide Library去Laod URL image到ImageView
// 這邊的"imageUrl"定義好之後 就可以在xml中的app:imageUrl使用，app:後面使用的名稱就是在此定義
@BindingAdapter("imageUrl")
fun bindImage(imgView: CircleImageView, imgUrl: String?) {
    imgUrl?.let {
        // convert imageURL to URI
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        // load image uri to imageview
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    // 當resource loading會顯示
                    .placeholder(R.drawable.loading_animation)
                    // 當出現錯誤時會顯示
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("imageUrl_2")
fun bindImage(imgView: AppCompatImageView, imgUrl: String?) {
    imgUrl?.let {
        // convert imageURL to URI
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        // load image uri to imageview
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    // 當resource loading會顯示
                    .placeholder(R.drawable.loading_animation)
                    // 當出現錯誤時會顯示
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}




