package subtask2

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        return if (number < 3) null
        else finder(square(number), number - 1)?.toTypedArray()
    }

    private fun finder(number: Int, position: Int): ArrayList<Int>? {
        for (i in position downTo 1) {
            val rest = number - square(i)
            if (rest == 0) return arrayListOf(i)
            if (rest < 0) return null
            var radical = kotlin.math.sqrt(rest.toDouble()).toInt()
            if (radical >= i) radical = i - 1
            val result = finder(rest, radical)
            if (result != null) {
                result.add(i)
                return result
            }
        }
        return null
    }

    private fun square(x: Int) = x * x
}