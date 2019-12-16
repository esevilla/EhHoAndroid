package io.esevilla.eh_ho

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
}

    fun login(view: View) {
        val intent: Intent = Intent(this, TopicsActivity::class.java)
        startActivity(intent)
    }

}
