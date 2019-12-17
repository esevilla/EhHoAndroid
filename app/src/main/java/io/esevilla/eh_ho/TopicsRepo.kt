package io.esevilla.eh_ho

object TopicsRepo {
    val topics: MutableList<Topic> = mutableListOf()
    get() {
        if (field.isEmpty())
            field.addAll(dummyTopics())

        return field
    }

   // fun dummyTopics(count: Int = 50): List<Topic> {
   //     val dummyTopics: MutableList<Topic> = mutableListOf()
    //    for (i in 1..count) {
      //      val topic: Topic = Topic(title = "Title $i", content = "Content $i")
        //    dummyTopics.add(topic)
        //}
        //return dummyTopics
    //}

    fun dummyTopics(count: Int = 50): List<Topic> {
       return (1..count).map{
            Topic(title = "Title $it", content = "Content $it")
        }
    }

}