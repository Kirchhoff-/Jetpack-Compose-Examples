package com.kirchhoff.composeexamples.expandablelist.repository

import com.kirchhoff.composeexamples.expandablelist.model.ExpandableListData
import java.util.UUID
import kotlin.random.Random

@Suppress("unused")
class ExpandableListRepository {

    fun items(): List<ExpandableListData> = mutableListOf<ExpandableListData>().apply {
        for (i in 0..Random.nextInt(10, 100)) {
            add(
                ExpandableListData(
                    title = Random.nextString(),
                    description = Random.nextString(20)
                )
            )
        }
    }

    private fun Random.nextString(length: Int = 5): String =
        UUID.randomUUID().toString().substring(length)
}
