package binar.andlima.datastore_preflogin_example_basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_main.*

class SplashActivity : AppCompatActivity() {

    lateinit var dataLogin : DataStoreLogin
    lateinit var usernama : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        dataLogin = DataStoreLogin(this)
        dataLogin.userUsernameFlow.asLiveData().observe(this,{
            usernama = it.toString()
        })


        Handler().postDelayed({
            if (usernama.isNullOrEmpty()){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }


        },3000)
    }
}