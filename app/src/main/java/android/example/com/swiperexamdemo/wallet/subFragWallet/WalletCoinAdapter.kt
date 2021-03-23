package android.example.com.swiperexamdemo.wallet.subFragWallet

import android.example.com.swiperexamdemo.data.DataStructure
import android.example.com.swiperexamdemo.databinding.ViewItemCoinBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

    class WalletCoinAdapter : ListAdapter<DataStructure, WalletCoinAdapter.WalletPagerViewHolder>(DiffCallback) {

        class WalletPagerViewHolder(private var binding: ViewItemCoinBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(data: DataStructure) {
                binding.llCoinDetail.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                binding.data = data
                // This is important, because it forces the data binding to execute immediately,
                // which allows the RecyclerView to make the correct view size measurements update immediately
                binding.executePendingBindings()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletPagerViewHolder {
            return WalletPagerViewHolder(
                ViewItemCoinBinding.inflate(LayoutInflater.from(parent.context))
            )
        }


        override fun onBindViewHolder(holder: WalletPagerViewHolder, position: Int) {
            val data = getItem(position)
            // 呼叫onClick Function
//        holder.itemView.setOnClickListener {
//            onClickListener.onClick(zooArea)
//        }

            holder.bind(data)

        }

        companion object DiffCallback : DiffUtil.ItemCallback<DataStructure>() {
            // 用此判斷item是不是同樣的item並且在smae position (用ID判斷)
            override fun areItemsTheSame(oldItem: DataStructure, newItem: DataStructure): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: DataStructure, newItem: DataStructure): Boolean {
                return oldItem == newItem
            }
        }
    }
