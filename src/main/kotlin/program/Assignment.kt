package program

// <присваивание> ::= <идент> = <выражение>;
class Assignment(private val line: Int, private val data: String) {

    val ident: Ident
    val expression: Expression

    init {
        val splittedData = data.split('=')
        if (splittedData.size != 2){
            throw Exception("Line $line: Each assignment line must contain only one =")
        }
        ident = splittedData[0].also { it.checkIdent(line) }
        expression = Expression(line, splittedData[1])

    }
}