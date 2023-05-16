package algorithm

object MergeSort {

    fun start(items: List<Int>): List<Int> {

        if (items.size <= 1) return items

        val middle = items.size / 2

        val left = items.subList(0, middle)
        val right = items.subList(middle, items.size)

        return merge(start(left), start(right))
    }

    private fun merge(left: List<Int>, right: List<Int>): List<Int> {

        var indexLeft = 0
        var indexRight = 0

        val newList: MutableList<Int> = mutableListOf()

        while (indexLeft < left.count() && indexRight < right.count()) {

            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }

        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }

        return newList
    }

}