package android.example.com.swiperexamdemo.data

import androidx.versionedparcelable.VersionedParcelize

data class WalletDataStructure(
    val name: String,
    val imgUrl: String,
    val _id: Long = 0L
)

data class VoucherDataStructure(
    val name: String,
    val _id: Int
)

