package program

// <присваивание> ::= <идент> = <выражение>;
class Assignment(private val data: String) {

    val ident: Ident
    val expression: Expression

    init {
        val splittedData = data.split('=')
        if (splittedData.size != 2){
            throw Exception("Each assignment line must contain only one =")
        }
        ident = splittedData[0].trim().also { it.checkIdent() }
        expression = Expression(splittedData[1])

    }
}