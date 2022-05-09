package binar.andlima.datastore_preflogin_example_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var dataLogin : DataStoreLogin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dataLogin = DataStoreLogin(this)

        btnRegister.setOnClickListener {
            val rUsername = etRegistUsername.text.toString()
            val rPassword = etRegistPassword.text.toString()
            GlobalScope.launch {
                dataLogin.saveData(rUsername,rPassword)
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                finish()
            }
            finish()
        }

//        dataLogin.userUsernameFlow.asLiveData().observe(this,{
//            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
//        })
    }
}