package com.bb.yzbbanban.salary.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import com.bb.yzbbanban.salary.R
import com.bb.yzbbanban.salary.fragment.CommentSalaryFrg
import com.bb.yzbbanban.salary.fragment.PreformanceSalaryFrg
import com.bb.yzbbanban.salary.fragment.SpringSalaryFrg
import com.bb.yzbbanban.salary.fragment.SummerSalaryFrg

class MainActivity : AppCompatActivity() {
    private var mDrawerlayout: DrawerLayout? = null
    private var navView: NavigationView? = null
    private var frgs: MutableList<Fragment>? = null
    private var adapter: FragmentPagerAdapter? = null
    private var position: Int = 0
    private var flContainer: FrameLayout? = null
    private var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initDate()
        setListener()

    }

    private fun setListener() {
        navView?.setCheckedItem(R.id.nav_common)
        navView?.setNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                mDrawerlayout?.closeDrawers()
                when (item.itemId) {
                    R.id.nav_common
                    -> {
                        position = 0
                        toolbar?.setTitle(this@MainActivity.resources.getString(R.string.nav_common))
                    }
                    R.id.nav_performance
                    -> {
                        position = 1
                        toolbar?.setTitle(this@MainActivity.resources.getString(R.string.nav_performance))
                    }

                    R.id.nav_spring
                    -> {
                        position = 2
                        toolbar?.setTitle(this@MainActivity.resources.getString(R.string.nav_spring))
                    }
                    R.id.nav_summer
                    -> {
                        position = 3
                        toolbar?.setTitle(this@MainActivity.resources.getString(R.string.nav_summer))
                    }
                }
                selectFragment(position)
                return true
            }
        }
        )

    }

    private fun initDate() {
        frgs = mutableListOf<Fragment>()
        frgs?.add(CommentSalaryFrg())
        frgs?.add(PreformanceSalaryFrg())
        frgs?.add(SpringSalaryFrg())
        frgs?.add(SummerSalaryFrg())
        adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment? {
                return frgs?.get(position)
            }

            override fun getCount(): Int {
                return frgs?.size as Int
            }
        }
        selectFragment(0)
    }


    private fun initView() {
        toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        flContainer = findViewById(R.id.fl_container) as FrameLayout
        mDrawerlayout = findViewById(R.id.draw_layout) as DrawerLayout
        navView = findViewById(R.id.nav_view) as NavigationView
        var actionBar = getSupportActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.nav)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> mDrawerlayout?.openDrawer(GravityCompat.START)

        }
        return true
    }


    private var lastFragment: Any? = null
    private var lastPosition: Int = 0

    private fun selectFragment(position: Int) {
        //destort another fragment,falg set null
        if (lastFragment != null) {
            adapter?.destroyItem(flContainer, lastPosition, lastFragment)
            lastFragment = null
        }

        //set local frgment
        val fragment = adapter?.instantiateItem(flContainer, position)
        //
        adapter?.setPrimaryItem(flContainer, 0, fragment)
        //
        adapter?.finishUpdate(flContainer)
        //
        lastFragment = fragment
        lastPosition = position
    }

}


