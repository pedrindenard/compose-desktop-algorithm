package algorithm

object QuickSort {

    fun start(items: List<Int>): List<Int> {

        if (items.count() < 2) return items

        val pivot = items[items.count() / 2]

        val equal = items.filter { it == pivot }
        val less = items.filter { it < pivot }
        val greater = items.filter { it > pivot }

        return start(less) + equal + start(greater)
    }

}