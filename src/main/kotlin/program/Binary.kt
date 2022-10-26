package program

// <бин. оп.> ::= - | + | * | /
typealias Binary = Char

fun Unary.checkBinary() {
    if (this != '-' && this != '+' && this != '*' && this != '/') {
        throw Exception("Binary operator can only be - or + or * or /")
    }
}