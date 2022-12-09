
val matrix = mapOf(
    Move.ROCK to mapOf(
        Move.SCISSORS to Move.LOSE,
        Move.ROCK to Move.DRAW,
        Move.PAPER to Move.WIN,
    ),
    Move.PAPER to mapOf(
        Move.ROCK to Move.LOSE,
        Move.PAPER to Move.DRAW,
        Move.SCISSORS to Move.WIN,
    ),
    Move.SCISSORS to mapOf(
        Move.PAPER to Move.LOSE,
        Move.SCISSORS to Move.DRAW,
        Move.ROCK to Move.WIN,
    ),
)

fun convertMatrix() = buildMap {
    matrix.toMutableMap().forEach {
        put(
            it.key,
            buildMap {
                it.value.forEach {
                    put(it.value, it.key)
                }
            }
        )
    }
}
enum class Move(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3),

    LOSE(0),
    DRAW(3),
    WIN(6),
}

fun main() {
    fun part1(input: List<String>): Int =
        input.map {
            it.split(" ").map {
                when (it) {
                    "A", "X" -> Move.ROCK
                    "B", "Y" -> Move.PAPER
                    "C", "Z" -> Move.SCISSORS
                    else -> { throw IllegalArgumentException() }
                }
            }
        }.map {
            it.last().score + matrix.getValue(it.first()).getValue(it.last()).score
        }.sum()

    fun part2(input: List<String>): Int =
        input.map {
            it.split(" ").map {
                when (it) {
                    "A" -> Move.ROCK
                    "B" -> Move.PAPER
                    "C" -> Move.SCISSORS

                    "X" -> Move.LOSE
                    "Y" -> Move.DRAW
                    "Z" -> Move.WIN
                    else -> { throw IllegalArgumentException() }
                }
            }
        }.map {
            it.last().score + convertMatrix().getValue(it.first()).getValue(it.last()).score
        }.sum()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println(part1(input))

    check(part2(testInput) == 12)
    println(part2(input))
}
