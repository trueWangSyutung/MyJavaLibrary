package cn.syutung.GraphLibrary

import java.util.*
import kotlin.random.Random.Default.Companion

class EdgeList : ArrayList<Edge?>() {
    fun findByFrom(i: Int): EdgeList {
        val edges = EdgeList()
        for (edge in this) {
            if (edge != null) {
                if (edge.from == i) {
                    edges.add(edge)
                }
            }
        }
        return edges
    }

    fun sort() {
        var ex = true
        var i = 1
        while (i < this.size && ex) {
            ex = false
            for (j in 0 until this.size - i) {
                if (this[j]!!.weight > this[j + 1]!!.weight) {
                    swap(this, j, j + 1)
                    ex = true
                }
            }
            i++
        }
    }

    companion object {
        private fun swap(edges: EdgeList, i: Int, j: Int) {
            val temp = edges[j]
            edges[j] = edges[i]
            edges[i] = temp
        }
    }
}