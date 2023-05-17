package models

enum class Data(
    val value: Int,
    val fileName: String
) {
    MINIMUM(
        value = 1000,
        fileName = "algorithm_minimum_data.txt"
    ),
    SMALL(
        value = 5000,
        fileName = "algorithm_small_data.txt"
    ),
    AVERAGE(
        value = 10000,
        fileName = "algorithm_average_data.txt"
    ),
    LONG(
        value = 50000,
        fileName = "algorithm_long_data.txt"
    ),
    EXTENSIVE(
        value = 100000,
        fileName = "algorithm_extensive_data.txt"
    ),
    BIG(
        value = 200000,
        fileName = "algorithm_big_data.txt"
    ),
    HUGE(
        value = 500000,
        fileName = "algorithm_huge_data.txt"
    );
}