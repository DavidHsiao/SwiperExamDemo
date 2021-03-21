package android.example.com.swiperexamdemo.wallet.subFragment

import android.annotation.SuppressLint
import android.example.com.swiperexamdemo.R
import android.example.com.swiperexamdemo.data.Reward
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WalletPagerAdapter : RecyclerView.Adapter<WalletPagerAdapter.WalletPagerViewHolder>() {

    private var mDataList: List<Reward> = mutableListOf()

    class WalletPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(data: Reward?) {
//            itemView.tv_title.text = data?.name
//            itemView.tv_amount.text = "+"+data?.amount.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletPagerViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.view_item_coin, parent, false)
        return WalletPagerViewHolder(layout)

    }


    override fun onBindViewHolder(holder: WalletPagerViewHolder, position: Int) {
        val data = mDataList[position]
        // 呼叫onClick Function
//        holder.itemView.setOnClickListener {
//            onClickListener.onClick(zooArea)
//        }

        holder.bind(data)

    }

    fun setData(newDataList: List<Reward>?) {
        mDataList = newDataList ?: mutableListOf()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }
}

//class WalletPagerAdapter : ListAdapter<Reward, WalletPagerAdapter.WalletPagerViewHolder>(DiffCallback) {
//
//    private var mDataList: List<Reward> = mutableListOf()
//    class WalletPagerViewHolder(private var binding: ViewItemCoinBinding):
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(data: Reward) {
//            binding.data = data
//            // This is important, because it forces the data binding to execute immediately,
//            // which allows the RecyclerView to make the correct view size measurements update immediately
//            binding.executePendingBindings()
//        }
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletPagerViewHolder {
//        return WalletPagerViewHolder(
//            ViewItemCoinBinding.inflate(LayoutInflater.from(parent.context))
//        )
//    }
//
//
//    override fun onBindViewHolder(holder: WalletPagerViewHolder, position: Int) {
//        val data = mDataList[position]
//        // 呼叫onClick Function
////        holder.itemView.setOnClickListener {
////            onClickListener.onClick(zooArea)
////        }
//
//        holder.bind(data)
//
//    }
//
//    fun setData(newDataList: List<Reward>?) {
//        mDataList = newDataList ?: mutableListOf()
//        notifyDataSetChanged()
//    }
//
//
//    companion object DiffCallback : DiffUtil.ItemCallback<Reward>() {
//        // 用此判斷item是不是同樣的item並且在smae position (用ID判斷)
//        override fun areItemsTheSame(oldItem: Reward, newItem: Reward): Boolean {
//            return oldItem._id == newItem._id
//        }
//
//        override fun areContentsTheSame(oldItem: Reward, newItem: Reward): Boolean {
//            return oldItem == newItem
//        }
//    }
//}