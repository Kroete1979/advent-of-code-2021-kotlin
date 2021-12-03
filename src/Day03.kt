fun main() {
    data class Diagnostics(
        val first: Int = 0,
        val second: Int = 0,
        val third: Int = 0,
        val fourth: Int = 0,
        val fifth: Int = 0,
        val sixth: Int = 0,
        val seventh: Int = 0,
        val eighth: Int = 0,
        val ninth: Int = 0,
        val tenth: Int = 0,
        val eleventh: Int = 0,
        val twelfth: Int = 0,
    )

    fun ltztzeo(number: Int) = if (number < 0) 0 else 1

    fun part1(input: List<String>): Pair<Int, Int> = input
        .fold(Diagnostics()) { acc, number ->
            Diagnostics(
                acc.first + if (number[0] == '1') 1 else -1,
                acc.second + if (number[1] == '1') 1 else -1,
                acc.third + if (number[2] == '1') 1 else -1,
                acc.fourth + if (number[3] == '1') 1 else -1,
                acc.fifth + if (number[4] == '1') 1 else -1,
                acc.sixth + if (number[5] == '1') 1 else -1,
                acc.seventh + if (number[6] == '1') 1 else -1,
                acc.eighth + if (number[7] == '1') 1 else -1,
                acc.ninth + if (number[8] == '1') 1 else -1,
                acc.tenth + if (number[9] == '1') 1 else -1,
                acc.eleventh + if (number[10] == '1') 1 else -1,
                acc.twelfth + if (number[11] == '1') 1 else -1,
            )
        }.let {
            Integer.parseUnsignedInt(
                "${ltztzeo(it.first)}${ltztzeo(it.second)}${ltztzeo(it.third)}${ltztzeo(it.fourth)}${ltztzeo(it.fifth)}${
                    ltztzeo(
                        it.sixth
                    )
                }${ltztzeo(it.seventh)}${ltztzeo(it.eighth)}${ltztzeo(it.ninth)}${ltztzeo(it.tenth)}${ltztzeo(it.eleventh)}${
                    ltztzeo(
                        it.twelfth
                    )
                }",
                2
            )
        }.let {
            Pair(
                it,
                Integer.parseUnsignedInt(
                    Integer.toBinaryString(it)
                        .replace('1', '2')
                        .replace('0', '1')
                        .replace('2', '0'),
                    2
                )
            )
        }

    fun part2(input: List<String>): Triple<Int, Int, Int>? = null

    val input = readInput("Day03")

    val part1Result = part1(input)
    println("$part1Result - ${part1Result.second * part1Result.first}")
    val part2Result = part2(input)
    println("")
}