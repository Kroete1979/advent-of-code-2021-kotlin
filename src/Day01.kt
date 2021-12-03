fun main() {
    fun part1(input: List<String>): Int = input
        .map(String::toInt)
        .zipWithNext { a, b -> if (a < b) 1 else 0 }
        .sum()

    fun part2(input: List<String>): Int {
        val depths = input.map(String::toInt)

        return depths
            .mapIndexed { index, depth -> if (index < 2) -1 else depths[index - 2] + depths[index - 1] + depth }
            .drop(2)
            .zipWithNext { a, b -> if (a < b) 1 else 0 }
            .sum()
    }

    val input = readInput("Day01")

    println(part1(input))
    println(part2(input))
}
