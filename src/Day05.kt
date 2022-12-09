

fun main() {

    fun makeStack(input: List<String>): List<List<Char>> {
        val stack = ArrayDeque<String>()
        for (i in input) {
            if (i.first() == '[') { stack.addFirst(i) } else {
                i.last().digitToInt()
                break
            }
        }
    }
    fun part1(input: List<String>): Int = 0

    fun part2(input: List<String>): Int = 0

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 2)

    val input = readInput("Day05")
    println(part1(input))

    check(part2(testInput) == 4)
    println(part2(input))
}
