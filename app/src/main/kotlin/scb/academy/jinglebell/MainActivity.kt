package scb.academy.jinglebell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import scb.academy.jinglebell.fragment.AFragment
import scb.academy.jinglebell.fragment.BFragment
import scb.academy.jinglebell.fragment.CFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bnvNavigation: BottomNavigationView

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener when (item.itemId) {
            R.id.action_a, R.id.action_b, R.id.action_c -> {
                changeFragment(item.itemId)
                true
            }

            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnvNavigation = findViewById(R.id.bnv_navigation)
        bnvNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        if (fragment == null) {
            changeFragment(bnvNavigation.selectedItemId)
        }
    }

    private fun changeFragment(id: Int) {
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        when (id) {
            R.id.action_a -> {
                if (fragment is AFragment) return

                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AFragment())
                    .commit()
            }

            R.id.action_b -> {
                if (fragment is BFragment) return

                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, BFragment())
                    .commit()
            }

            R.id.action_c -> {
                if (fragment is CFragment) return

                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CFragment())
                    .commit()
            }
        }
    }
}
