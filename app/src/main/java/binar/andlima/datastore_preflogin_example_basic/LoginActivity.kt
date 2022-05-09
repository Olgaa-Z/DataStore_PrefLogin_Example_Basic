package binar.andlima.datastore_preflogin_example_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var dataLogin : DataStoreLogin
    lateinit var usernama : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dataLogin = DataStoreLogin(this)
        dataLogin.userUsernameFlow.asLiveData().observe(this,{
           usernama=  it.toString()
        })




        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }


        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if(username.isEmpty()){
                etUsername.setError("Isi Username")
            }else if(password.isEmpty()){
                etPassword.setError("Isi Password")
            } else if (username == usernama){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Username Salah", Toast.LENGTH_LONG).show()
            }


//            Toast.makeText(this, usernama, Toast.LENGTH_LONG).show()



        }
    }
}