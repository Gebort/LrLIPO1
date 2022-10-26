package program

// <ун. оп.> ::= -
typealias Unary = Char

fun Unary.checkUnary() {
    if (this != '-') {
        throw Exception("Unary operator can only be -")
    }
}
