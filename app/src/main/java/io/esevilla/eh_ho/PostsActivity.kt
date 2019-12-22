package io.esevilla.eh_ho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.esevilla.eh_ho.data.TopicsRepo
import kotlinx.android.synthetic.main.activity_posts.*
import java.lang.IllegalArgumentException

const val EXTRA_TOPIC_ID = "topic_id"

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        val topicId = intent.getStringExtra(EXTRA_TOPIC_ID)

        if(topicId != null && topicId.isNotEmpty()) {
            val topic = TopicsRepo.getTopic(topicId)

            topic?.let {
                labelTitle.text = it.title
            }
        } else {
            throw IllegalArgumentException("You should provide an id for the topic")
        }
    }
}


