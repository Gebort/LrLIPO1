package program

// <идент> ::= <буква> | <буква> <идент>
typealias Ident = String

fun Ident.checkIdent() {
    this.trim{ it == ' ' }.let {
        if (it.isEmpty()) {
            throw Exception("Missed variable")
        }
        if (it.contains(Regex("[^a-zA-Zа-яА-Я]"))) {
            throw Exception("Only english and russian alphabet can be used in a var name")
        }
    }
}
