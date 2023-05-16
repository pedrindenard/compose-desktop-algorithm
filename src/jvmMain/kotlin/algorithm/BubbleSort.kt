package algorithm

object BubbleSort {

    fun start(items: ArrayList<Int>): ArrayList<Int> {

        var swap = true

        while (swap) {

            swap = false

            for (i in 0 until items.size - 1) {

                if (items[i] > items[i + 1]) {

                    val temp = items[i]

                    items[i] = items[i + 1]
                    items[i + 1] = temp

                    swap = true
                }
            }
        }

        return items
    }

}