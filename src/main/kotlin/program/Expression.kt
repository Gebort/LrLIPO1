package program

// <выражение> ::= <ун. оп.> <подвыражение> | <подвыражение>
class Expression(private val data: String) {

    val unary: Unary?
    val subExpression: SubExpression

    init {
        val trimmedData = data.trim { it == ' ' }
        if (trimmedData.isEmpty()) {
            throw Exception("Empty expression")
        }

        unary = try {
            trimmedData.first().also { it.checkUnary() }
        } catch (e: Exception) {
            null
        }

        if (unary != null) {
            trimmedData.removePrefix(unary.toString())
        }

        subExpression = SubExpression(trimmedData)
    }

}