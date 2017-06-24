package com.bb.yzbbanban.salary.utils

import android.content.Context
import android.util.Log
import com.bb.yzbbanban.salary.R

/**
 * Created by YZBbanban on 2017/6/24.
 */
class StringUtils {
    companion object {
        fun setTitle(context: Context?, id: Int?): String {
            Log.i("ban", "setTitle: "+id)

            when (id) {
                0 -> {
                    return context?.resources?.getString(R.string.base_salary).toString()
                }
                1 -> {
                    return context?.resources?.getString(R.string.bit_late).toString()
                }
                2 -> {
                    return context?.resources?.getString(R.string.late).toString()
                }
                3 -> {
                    return context?.resources?.getString(R.string.workday).toString()
                }
                4 -> {
                    return context?.resources?.getString(R.string.absence).toString()
                }
                5 -> {
                    return context?.resources?.getString(R.string.social_security).toString()
                }
                6 -> {
                    return context?.resources?.getString(R.string.salary_performance).toString()
                }
                7 -> {
                    return context?.resources?.getString(R.string.total_people).toString()
                }
                8 -> {
                    return context?.resources?.getString(R.string.actual_people).toString()
                }

            }
            return ""
        }
    }
}