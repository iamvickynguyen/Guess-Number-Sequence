//Author: Vicky Nguyen

package com.example.admin.guessnumbersequence

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_guess_numbers.*


class GuessNumbers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_numbers)

        var dm = mutableListOf<Int>()
        for (i in 1..4) {
            var r = 1 + (Math.random() * 4).toInt()
            dm.add(r)
        }

        btn1.setOnClickListener(View.OnClickListener {
            edittxt.append("1 ")
        })
        btn2.setOnClickListener(View.OnClickListener {
            edittxt.append("2 ")
        })
        btn3.setOnClickListener(View.OnClickListener {
            edittxt.append("3 ")
        })
        btn4.setOnClickListener(View.OnClickListener {
            edittxt.append("4 ")
        })

        btnresult.setOnClickListener(View.OnClickListener {
            txtcorrectresult.text=""
            var dn = mutableListOf<Int>()

            var chuoinhap = edittxt.text.toString()
            chuoinhap = chuoinhap.trim()
            var chuoiedit = chuoinhap.split(" ")

            for (k in chuoiedit) {
                dn.add(k.toInt())
            }

            for (item2 in dn)
                txtresult.append(item2.toString() + " ")
            txtresult.text = txtresult.text.toString() + '\n'

            var coso = 0
            var dungsodungvitri = 0
            for (i in 0..dn.size-1)
                if (dm.contains(dn.get(i)) === true)
                    coso++

            for (i in 0..dn.size-1)
                if (dm.get(i)==dn.get(i))
                    dungsodungvitri++

            if (coso==4 && dungsodungvitri==4)
            {
                for (item in dm)
                    txtcorrectresult.append(item.toString() + " ")
                var build = AlertDialog.Builder(this@GuessNumbers)
                build.setTitle("CONGRATS!")
                build.setNegativeButton("OK", DialogInterface.OnClickListener
                { dialogInterface, i ->
                })
                var alert=build.create()
                build.show()
            }
            else
                Toast.makeText(this@GuessNumbers,"" + coso + " correct numbers" + '\n' + dungsodungvitri + " correct numbers and correct positions".toString(),Toast.LENGTH_LONG).show()

            edittxt.text.clear()
        })

        btnhint.setOnClickListener(View.OnClickListener {
            txtcorrectresult.text=""
            for (item in dm)
                txtcorrectresult.append(item.toString()+ " ")
        })

        btnagain.setOnClickListener(View.OnClickListener {
            txtcorrectresult.text=""
            txtresult.text = ""
            edittxt.text.clear()
            dm.clear()
            for (i in 1..4) {
                var r = 1 + (Math.random() * 4).toInt()
                dm.add(r)
            }
        })

        infoimg.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@GuessNumbers,"enter 4 numbers",Toast.LENGTH_SHORT).show()
        })
    }

}
