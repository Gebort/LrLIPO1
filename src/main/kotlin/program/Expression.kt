package program

// <выражение> ::= <ун. оп.> <подвыражение> | <подвыражение>
class Expression(private val line: Int, private val data: String) {

    val unary: Unary?
    val subExpression: SubExpression

    init {
        val trimmedData = data.trim { it == ' ' }
        if (trimmedData.isEmpty()) {
            throw Exception("Line $line: Empty expression")
        }

        unary = try {
            trimmedData.first().also { it.checkUnary(line) }
        } catch (e: Exception) {
            null
        }

        if (unary != null) {
            trimmedData.removePrefix(unary.toString())
        }

        subExpression = SubExpression(line, trimmedData)
    }

}