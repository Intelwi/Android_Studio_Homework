package com.daftmobile.a4bhomework2

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val dialog: DialogElem = DialogElem()
        button1.setOnClickListener {
            val fm = supportFragmentManager
            dialog.setSignColor("red")
            dialog.show(fm,"cos")
        }

        button2.setOnClickListener {
            val fm = supportFragmentManager
            dialog.setSignColor("green")
            dialog.show(fm,"cos")
        }

        button3.setOnClickListener {
            val fm = supportFragmentManager
            dialog.setSignColor("blue")
            dialog.show(fm,"cos")
        }

    }
}

class DialogElem : DialogFragment() {

        var color: String = "red"
        fun setSignColor(color: String){
            this.color = color
        }
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {
                // Use the Builder class for convenient dialog construction
                val builder = AlertDialog.Builder(it)

                var text = getString(R.string.welcome_message, color)

                builder.setMessage(text)
                    .setPositiveButton("ok",
                        DialogInterface.OnClickListener { dialog, id ->
                            // FIRE ZE MISSILES!
                        })
                // Create the AlertDialog object and return it
                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }
}