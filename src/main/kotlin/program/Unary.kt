package program

// <ун. оп.> ::= -
typealias Unary = Char

fun Unary.checkUnary(line: Int) {
    if (this != '-') {
        throw Exception("Line $line: Unary operator can only be -")
    }
}
