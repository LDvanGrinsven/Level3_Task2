package com.example.studentportal

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_portal_add.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class PortalAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal_add)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }
    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create Link"
        btnAdd.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {
        if (etTitle.text.toString().isNotBlank() && etUrl.text.toString().isNotBlank()) {
            //get the url and check the length of it        }
            var url = etUrl.text.toString()

            //save the portal en return
            val portal = Portal(etTitle.text.toString(), url)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(
                this, "The portal cannot be empty"
                , Toast.LENGTH_SHORT
            ).show()
        }
    }
}
