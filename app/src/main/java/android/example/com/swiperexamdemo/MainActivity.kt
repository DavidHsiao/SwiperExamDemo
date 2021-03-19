package android.example.com.swiperexamdemo

import android.example.com.swiperexamdemo.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.LabelVisibilityMode

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        navController = navHostFragment.navController


        // 讓NavigationUI認識navView
//        NavigationUI.setupWithNavController(binding.bottomNavView, navController)

        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        with(binding) {

            bottomNavView.apply {
                labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

                setOnNavigationItemSelectedListener { item ->
                    Log.d(TAG, "OnNavigationItemSelected(): Position - ${item.order}")
//                    when(item.order){
//                        0->navController.navigate(R.id.walletFragment)
//                        1->navController.navigate(R.id.walletFragment)
//                        2->navController.navigate(R.id.walletFragment)
//                        3->navController.navigate(R.id.walletFragment)
//                        4->navController.navigate(R.id.walletFragment)
//                        else -> {
//                            navController.navigate(R.id.walletFragment)
//                        }
//                    }

                    return@setOnNavigationItemSelectedListener true
                }
                navController.navigate( R.id.walletFragment)

            }
        }

    }
}