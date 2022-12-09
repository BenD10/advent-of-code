

val prio by lazy { ('a'..'z') + ('A'..'Z') }
fun Char.getPriority() = prio.indexOf(this) + 1

fun main() {
    fun part1(input: List<String>): Int {
        return input.map {
            it.chunked(it.length / 2) {
                it.map { it.getPriority() }
            }
        }.map {
            (it.first().toSet().intersect(it.last().toSet()))
        }.sumOf { it.sum() }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.toSet() }.chunked(3).map {
            it[0].intersect(it[1].intersect(it[2])).map { it.getPriority() }
        }.sumOf { it.sum() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    println(part1(testInput))
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println(part1(input))

    check(part2(testInput) == 70)
    println(part2(input))
}
