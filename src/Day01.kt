import java.lang.Integer.max

fun main() {
    fun part1(input: List<String>): Int {
        var currentMax = 0
        var accumulator = 0

        input.forEach {
            if (it.isEmpty()) {
                // Reached the end of this elf
                currentMax = max(currentMax, accumulator)
                accumulator = 0
            } else {
                accumulator += it.toInt()
            }
        }

        return currentMax
    }

    fun part2(input: List<String>): Int {
        val elfCalories = buildList<Int> {
            var acc = 0
            input.forEach {
                if (it.isEmpty()) {
                    add(acc)
                    acc = 0
                } else {
                    acc += it.toInt()
                }
            }
            add(acc)
        }.sortedDescending()

        return elfCalories.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))

    check(part2(testInput) == 45000)
    println(part2(input))
}
