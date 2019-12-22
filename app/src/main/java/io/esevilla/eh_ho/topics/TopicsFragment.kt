package io.esevilla.eh_ho.topics

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import io.esevilla.eh_ho.R
import io.esevilla.eh_ho.data.Topic
import io.esevilla.eh_ho.data.TopicsRepo
import kotlinx.android.synthetic.main.fragment_topics.*

class TopicsFragment : Fragment() {

    var topicsInteractionListener: TopicsInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is TopicsInteractionListener)
            topicsInteractionListener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_topics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TopicsAdapter { goToPosts(it) }
        adapter.setTopics(TopicsRepo.topics)

        listTopics.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        listTopics.adapter = adapter

        buttonCreate.setOnClickListener {
            goToCreateTopic()
        }
    }

    private fun goToCreateTopic() {
        topicsInteractionListener?.onGoToCreateTopic()
    }

    private fun goToPosts(it: Topic) {
        topicsInteractionListener?.onTopicSelected(it)
    }

    interface TopicsInteractionListener {
        fun onTopicSelected(topic: Topic)
        fun onGoToCreateTopic()
    }

}
