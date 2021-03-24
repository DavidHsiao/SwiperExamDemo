package android.example.com.swiperexamdemo.wallet.subFragVoucher


import android.example.com.swiperexamdemo.data.VoucherDataStructure
import android.example.com.swiperexamdemo.databinding.ItemVoucherBinding
import android.example.com.swiperexamdemo.databinding.ViewItemCoinBinding
import android.example.com.swiperexamdemo.wallet.subFragWallet.WalletCoinAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class WalletVoucherAdapter : ListAdapter<VoucherDataStructure, WalletVoucherAdapter.WalletVoucherViewHolder>(DiffCallback) {
    class WalletVoucherViewHolder(private var binding: ItemVoucherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: VoucherDataStructure) {
            binding.llVoucherDetail.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            binding.data = data
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements update immediately
            binding.executePendingBindings()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletVoucherAdapter.WalletVoucherViewHolder {
        return WalletVoucherAdapter.WalletVoucherViewHolder(
            ItemVoucherBinding.inflate(LayoutInflater.from(parent.context))
        )
    }


    override fun onBindViewHolder(holder: WalletVoucherAdapter.WalletVoucherViewHolder, position: Int) {
        val data = getItem(position)
        // 呼叫onClick Function
//        holder.itemView.setOnClickListener {
//            onClickListener.onClick(zooArea)
//        }

        holder.bind(data)

    }

    companion object DiffCallback : DiffUtil.ItemCallback<VoucherDataStructure>() {
        // 用此判斷item是不是同樣的item並且在smae position (用ID判斷)
        override fun areItemsTheSame(oldItem: VoucherDataStructure, newItem: VoucherDataStructure): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: VoucherDataStructure, newItem: VoucherDataStructure): Boolean {
            return oldItem == newItem
        }
    }
}
