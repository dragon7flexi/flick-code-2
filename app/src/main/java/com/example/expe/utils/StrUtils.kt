fun String.insertAt(index: Int, str: String): String {
    if (index !in 0..length) return this
    return substring(0, index) + str + substring(index)
}

fun String.removeAt(index: Int): String {
    if (index !in indices) return this
    return removeRange(index, index + 1)
}
