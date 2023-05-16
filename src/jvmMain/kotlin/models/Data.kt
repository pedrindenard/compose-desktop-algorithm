package models

@Suppress(names = ["unused"])
enum class Data(
    val value: Int,
    val fileName: String
) {
    MINIMUM(
        value = 100,
        fileName = "algorithm_minimum_data.txt"
    ),
    SMALL(
        value = 1000,
        fileName = "algorithm_small_data.txt"
    ),
    AVERAGE(
        value = 10000,
        fileName = "algorithm_average_data.txt"
    ),
    EXTENSIVE(
        value = 100000,
        fileName = "algorithm_extensive_data.txt"
    ),
    BIG(
        value = 1000000,
        fileName = "algorithm_big_data.txt"
    ),
    HUGE(
        value = 10000000,
        fileName = "algorithm_huge_data.txt"
    );
}