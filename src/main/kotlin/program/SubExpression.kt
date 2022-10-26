package program

// <подвыражение> ::= (<выражение>) | <операнд> | <подвыражение> <бин. оп.> <подвыражение>
class SubExpression(private val data: String) {

    val expression: Expression?
    val operand: Operand?
    val subExpression1: SubExpression?
    val subExpression2: SubExpression?
    val binary: Binary?

    init {
        val trimmedData = data.trim{ it == ' ' }

        if (trimmedData.isEmpty()) {
            throw Exception("Empty sub expression")
        }

        if (trimmedData.first() == '(' && trimmedData.last() == ')') {
            expression = Expression(trimmedData.substring(1, trimmedData.length-1))
            operand = null
            subExpression1 = null
            subExpression2 = null
            binary = null
        }
        else {
            operand = try {
                Operand(trimmedData)
            } catch (e: Exception) {
                null
            }
            if (operand != null) {
                expression = null
                subExpression1 = null
                subExpression2 = null
                binary = null
            }
            else {

                val binaryIndex = findBinaryIndex(trimmedData)
                val left =  trimmedData.substring(0, binaryIndex)
                val right = trimmedData.substring(binaryIndex + 1)

                binary = trimmedData[binaryIndex]
                subExpression1 = SubExpression(left)
                subExpression2 = SubExpression(right)
                expression = null
            }
        }
    }

    private fun isBinarySafe(char: Char): Boolean {
        return try {
            char.checkBinary()
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun findBinaryIndex(data: String): Int  {
        var openBrackets = 0
        data.forEachIndexed { i, char ->
            if (char == '(') {
                openBrackets++
            }
            else if (char == ')') {
                openBrackets--
            }
            if (openBrackets == 0 && isBinarySafe(char)){
                return i
            }
        }
        if (openBrackets > 0){
            throw Exception("Missing closing brackets")
        }
        else if (openBrackets < 0){
            throw Exception("Missing opening brackets")
        }
        throw Exception("No binary operator in line")
    }

}