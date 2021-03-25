package android.example.com.swiperexamdemo

import android.content.ActivityNotFoundException
import android.content.Intent
import android.example.com.swiperexamdemo.databinding.ActivityMainBinding
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // 宣告Navigation Controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        navController = navHostFragment.navController

        // 設定BottomNavigationView的Listener
        binding.bottomNavView.setOnNavigationItemSelectedListener(listener)

        // 預設畫面是在Wallet
        binding.bottomNavView.selectedItemId = R.id.nav_wallet
    }

    private var listener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        //設定navigationBar裡的item們的點擊事件 被點擊後採動態載入fragment的方式
        Log.d(TAG, "OnNavigationItemSelected(): Position - ${item.order}")
        navController.popBackStack()
        when (item.itemId) {
            R.id.nav_phone -> {

                navController.navigate(R.id.phoneFragment)
            }
            R.id.nav_chat -> {
                navController.navigate(R.id.chatFragment)
            }
            R.id.nav_scan -> {
                dispatchTakePictureIntent()
            }
            R.id.nav_swipe -> {
                navController.navigate(R.id.swipeFragment)
            }
            R.id.nav_wallet -> {
                navController.navigate(R.id.walletFragment)
            }
        }
        true
    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }


}