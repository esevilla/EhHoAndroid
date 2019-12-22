package io.esevilla.eh_ho.topics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.esevilla.eh_ho.R
import io.esevilla.eh_ho.data.Topic
import kotlinx.android.synthetic.main.item_topic.view.*

class TopicsAdapter(
    val topicClickListener: ((Topic) -> Unit)? = null
) : RecyclerView.Adapter<TopicsAdapter.TopicHolder>() {
    private val topics = mutableListOf<Topic>()

    private val listener : ((View) -> Unit) = {
        val topic = it.tag as Topic
        topicClickListener?.invoke(topic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false)

        return TopicHolder(view)
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: TopicHolder, position: Int) {
        val topic = topics[position]
        holder.topic = topic
        holder.itemView.setOnClickListener(listener)
    }

    fun setTopics(topics: List<Topic>) {
        this.topics.clear()
        this.topics.addAll(topics)
        notifyDataSetChanged()
    }

    inner class TopicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var topic : Topic? = null
            set(value) {
                field = value
                itemView.tag = field
                itemView.labelTitle.text = field?.title
            }
    }
}
