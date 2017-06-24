package com.bb.yzbbanban.salary.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bb.yzbbanban.salary.R
import com.bb.yzbbanban.salary.utils.StringUtils

/**
 * Created by YZBbanban on 2017/6/24.
 */
class CommentSalaryFrg : Fragment(), View.OnClickListener {


    private var tv_common_salary: TextView? = null
    private var tv_bit_late: TextView? = null
    private var tv_late: TextView? = null
    private var tv_workday: TextView? = null
    private var tv_absence: TextView? = null
    private var tv_social_security: TextView? = null
    private var tv_total_common_salary: TextView? = null

    private var ll_common_salary: LinearLayout? = null
    private var ll_bit_late: LinearLayout? = null
    private var ll_late: LinearLayout? = null
    private var ll_workday: LinearLayout? = null
    private var ll_absence: LinearLayout? = null
    private var ll_social_security: LinearLayout? = null

    private var btn_calculate: Button? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.common_frg, null)
        initView(view)
        setListener()
        return view
    }

    private fun setListener() {
        btn_calculate?.setOnClickListener(this@CommentSalaryFrg)
        ll_common_salary?.setOnClickListener(this@CommentSalaryFrg)
        ll_bit_late?.setOnClickListener(this@CommentSalaryFrg)
        ll_late?.setOnClickListener(this@CommentSalaryFrg)
        ll_workday?.setOnClickListener(this@CommentSalaryFrg)
        ll_absence?.setOnClickListener(this@CommentSalaryFrg)
        ll_social_security?.setOnClickListener(this@CommentSalaryFrg)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
        //计算
            R.id.btn_calculate -> {

            }
        //基本工资
            R.id.ll_common_salary -> {
                Log.i("ban", "ll_common_salary")
                setDialog(0)
            }
        //小迟到
            R.id.ll_bit_late -> {
                Log.i("ban", "ll_bit_late")
                setDialog(1)
            }
        //大迟到
            R.id.ll_late -> {
                Log.i("ban", "ll_late")
                setDialog(2)
            }
        //工作时间
            R.id.ll_workday -> {
                Log.i("ban", "ll_workday")
                setDialog(3)
            }
        //缺勤
            R.id.ll_absence -> {
                Log.i("ban", "ll_absence")
                setDialog(4)
            }
        //社保
            R.id.ll_social_security -> {
                Log.i("ban", "ll_social_security")
                setDialog(5)
            }
        }

    }

    private fun initView(view: View?) {
        tv_common_salary = view?.findViewById(R.id.tv_common_salary) as TextView
        tv_bit_late = view?.findViewById(R.id.tv_bit_late) as TextView
        tv_late = view?.findViewById(R.id.tv_late) as TextView
        tv_workday = view?.findViewById(R.id.tv_workday) as TextView
        tv_absence = view?.findViewById(R.id.tv_absence) as TextView
        tv_social_security = view?.findViewById(R.id.tv_social_security) as TextView
        tv_total_common_salary = view?.findViewById(R.id.tv_total_common_salary) as TextView

        ll_common_salary = view?.findViewById(R.id.ll_common_salary) as LinearLayout
        ll_bit_late = view?.findViewById(R.id.ll_bit_late) as LinearLayout
        ll_late = view?.findViewById(R.id.ll_late) as LinearLayout
        ll_workday = view?.findViewById(R.id.ll_workday) as LinearLayout
        ll_absence = view?.findViewById(R.id.ll_absence) as LinearLayout
        ll_social_security = view?.findViewById(R.id.ll_social_security) as LinearLayout

        btn_calculate = view?.findViewById(R.id.btn_calculate) as Button


    }

    private fun setDialog(id: Int?) {
        Log.i("ban", "id: " + id)
        var builder = AlertDialog.Builder(activity)
        var view = LayoutInflater.from(activity).inflate(R.layout.item_dialog, null)
        var tv_dialog_title = view.findViewById(R.id.tv_dialog_title) as TextView
        var et_dialog_content = view.findViewById(R.id.et_dialog_content) as EditText
        var btn_dialog_cancel = view.findViewById(R.id.btn_dialog_cancel) as Button
        var btn_dialog_ok = view.findViewById(R.id.btn_dialog_ok) as Button
        var title = StringUtils.setTitle(activity, id)
        tv_dialog_title.setText(title)
        builder.setView(view)
        var dialog = builder.create()
        dialog.show()

        btn_dialog_cancel.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog.dismiss()
            }
        })
        btn_dialog_ok.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if ("".equals(et_dialog_content.text.toString())) {
                    Toast.makeText(activity, "请输入内容", Toast.LENGTH_SHORT).show()
                } else {
                    setContent(id, et_dialog_content?.text.toString())
                    dialog.dismiss()
                }
            }
        })

    }

    private fun setContent(id: Int?, content: String?) {
        when (id) {
            0 -> {
                tv_common_salary?.setText(content)
            }
            1 -> {
                tv_bit_late?.setText(content)
            }
            2 -> {
                tv_late?.setText(content)
            }
            3 -> {
                tv_workday?.setText(content)
            }
            4 -> {
                tv_absence?.setText(content)
            }
            5 -> {
                tv_social_security?.setText(content)
            }
        }

    }


}