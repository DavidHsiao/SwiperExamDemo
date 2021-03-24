package android.example.com.swiperexamdemo.wallet.subFragWallet

import android.example.com.swiperexamdemo.R
import android.example.com.swiperexamdemo.data.WalletDataStructure
import android.example.com.swiperexamdemo.databinding.ViewItemCoinBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

private val ITEM_VIEW_TYPE_FOOTER = 0
private val ITEM_VIEW_TYPE_ITEM = 1


class WalletCoinAdapter : ListAdapter<WalletDataStructure, RecyclerView.ViewHolder>(DiffCallback) {

    class WalletPagerViewHolder(private var binding: ViewItemCoinBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: WalletDataStructure) {
            binding.llCoinDetail.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            binding.data = data
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements update immediately
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): WalletPagerViewHolder {
                // 用Parent View的Context來Inflate
                val layoutInflater = LayoutInflater.from(parent.context)

                // 使用DataBinding後的infalte是用此方法
                val view = ViewItemCoinBinding.inflate(layoutInflater, parent, false)

                // 回傳建好的ViewHolder給RecyclerView
                return WalletPagerViewHolder(view)
            }
        }

    }

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.view_item_ad, parent, false)
                return TextViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_FOOTER -> TextViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> WalletPagerViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType ${viewType}")
        }

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is WalletPagerViewHolder -> {
                val data = getItem(position)
                holder.bind(data)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            itemCount-1 -> ITEM_VIEW_TYPE_FOOTER
            else -> ITEM_VIEW_TYPE_ITEM
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<WalletDataStructure>() {
        // 用此判斷item是不是同樣的item並且在smae position (用ID判斷)
        override fun areItemsTheSame(
            oldItem: WalletDataStructure,
            newItem: WalletDataStructure
        ): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(
            oldItem: WalletDataStructure,
            newItem: WalletDataStructure
        ): Boolean {
            return oldItem == newItem
        }
    }
}
