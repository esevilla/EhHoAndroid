package io.esevilla.eh_ho

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_topics.*

class TopicsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topics)

      //  Log.d(TopicsActivity::class.java.simpleName, TopicsRepo.topics.toString())


        val adapter = TopicsAdapter()
        adapter.setTopics(TopicsRepo.topics)

        listTopics.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listTopics.adapter = adapter
    }
}