

fun main() {
    fun part1(input: List<String>): Int {
        return input.map {
            it.split(",").map {
                it.split("-").let {
                    (it.first().toInt()..it.last().toInt())
                }
            }.let { ls ->
                if (ls.first().all { ls.last().contains(it) } || ls.last().all { ls.first().contains(it) }) {
                    1
                } else {
                    0
                }
            }
        }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.map {
            it.split(",").map {
                it.split("-").let {
                    (it.first().toInt()..it.last().toInt())
                }
            }.let { ls ->
                if (ls.first().any { ls.last().contains(it) } || ls.last().any { ls.first().contains(it) }) {
                    1
                } else {
                    0
                }
            }
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    println(part1(input))

    check(part2(testInput) == 4)
    println(part2(input))
}
