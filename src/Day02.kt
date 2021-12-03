enum class Direction {
    FORWARD,
    DOWN,
    UP
}

fun main() {
    class Movement01(val direction: Direction, val distance: Int) {
        fun apply(position: Pair<Int, Int>): Pair<Int, Int> = when(direction) {
            Direction.FORWARD -> Pair(position.first + distance, position.second)
            Direction.DOWN -> Pair(position.first, position.second + distance)
            Direction.UP -> Pair(position.first, position.second - distance)
        }
    }

    fun part1(input: List<String>): Pair<Int, Int> = input.map {
        it.split(' ')
            .let { directionAndDistance ->
                Movement01(when(directionAndDistance[0]) {
                    "forward" -> Direction.FORWARD
                    "down" -> Direction.DOWN
                    "up" -> Direction.UP
                    else -> throw Exception("Unexpected direction found.")
                }, directionAndDistance[1].toInt()) }
    }.fold(Pair(0, 0)) { acc, movement -> movement.apply(acc) }

    class Movement02(val direction: Direction, val aim: Int) {
        fun apply(position: Triple<Int, Int, Int>): Triple<Int, Int, Int> = when(direction) {
            Direction.FORWARD -> Triple(position.first + aim, position.second + aim * position.third, position.third)
            Direction.DOWN -> Triple(position.first, position.second, position.third + aim)
            Direction.UP -> Triple(position.first, position.second, position.third - aim)
        }
    }

    fun part2(input: List<String>): Triple<Int, Int, Int> = input.map {
        it.split(' ')
            .let { directionAndDistance ->
                Movement02(when(directionAndDistance[0]) {
                    "forward" -> Direction.FORWARD
                    "down" -> Direction.DOWN
                    "up" -> Direction.UP
                    else -> throw Exception("Unexpected direction found.")
                }, directionAndDistance[1].toInt()) }
    }.fold(Triple(0, 0, 0)) { acc, movement -> movement.apply(acc) }

    val input = readInput("Day02")

    val part1Result = part1(input)
    println("$part1Result - ${part1Result.second * part1Result.first}")
    val part2Result = part2(input)
    println("$part2Result - ${part2Result.second * part2Result.first}")
}