package com.daftmobile.a4bhomework2

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val button1 = findViewById<Button>(R.id.button1)
    val button2 = findViewById<Button>(R.id.button2)
    val button3 = findViewById<Button>(R.id.button3)
    val dialog:com.daftmobile.a4bhomework2.DialogFragment = com.daftmobile.a4bhomework2.DialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
/*
    button1.setOnClickListener{
        dialog.onCreateDialog(Bundle?)

    }

    button2.setOnClickListener{
        dialog.onCreateDialog(Bundle?)

    }

    button3.setOnClickListener{
        dialog.onCreateDialog(Bundle?)

    }
*/

}

class DialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Button red was tapped")
                .setPositiveButton("ok",
                    DialogInterface.OnClickListener { dialog, id -> okHandler()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun okHandler(){}
}
