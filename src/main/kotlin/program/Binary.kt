package program

// <бин. оп.> ::= - | + | * | /
typealias Binary = Char

fun Unary.checkBinary(line: Int) {
    if (this != '-' && this != '+' && this != '*' && this != '/') {
        throw Exception("Line $line: Binary operator can only be - or + or * or /")
    }
}