
package binar.andlima.datastore_preflogin_example_basic

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var datalogin : DataStoreLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datalogin = DataStoreLogin(this)
        datalogin.userUsernameFlow.asLiveData().observe(this,{
            hellousername.text= "Hello, " +  it.toString()
        })


        btnLogout.setOnClickListener {
            GlobalScope.launch {
                DataStoreLogin(this@MainActivity).clearData()
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
            }
        }


    }

    override fun onBackPressed() {

        AlertDialog.Builder(this)
            .setTitle("Tutup Aplikasi")
            .setMessage("Yakin tutup dari aplikasi?")
            .setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                finishAffinity()
            }
            .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }
            .show()


    }
}