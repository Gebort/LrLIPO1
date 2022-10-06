package program

// <идент> ::= <буква> | <буква> <идент>
typealias Ident = String

fun Ident.checkIdent(line: Int) {
    this.trim{ it == ' ' }.let {
        if (it.isEmpty()) {
            throw Exception("Line $line: Missed variable")
        }
        if (it.contains(Regex("[^a-zA-Zа-яА-Я]"))) {
            throw Exception("Line $line: Only english and russian alphabet can be used in a var name")
        }
    }
}
