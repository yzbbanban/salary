package com.bb.yzbbanban.salary.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bb.yzbbanban.salary.R

/**
 * Created by YZBbanban on 2017/6/24.
 */
class PreformanceSalaryFrg: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var  view=inflater?.inflate(R.layout.performance_frg,null)
        initView(view)
        return view
    }

    private fun initView(view: View?) {
    }


}