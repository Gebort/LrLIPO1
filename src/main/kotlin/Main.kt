import program.Program

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        test(
            " Var a, ba, c; a",
            "Var a1, b, c; b",
            "Var a, bb , c; c",
            "Var a1, 123, 123",
            "a, b, c; b",
            "Var a, b, c ",
            "Var a, , c; d",
            "Var a, b, c; a = 7;",
            "Var a, b; a = 6",
            "Var a, b, c; a;",
            "Var a, b, c; a = ;",
            "Var a, b, c; a = b + 5;",
            "Var a, b, c; a = c + b * a - 3;",
            "Var a, b, c; a = c + (b + c);",
            "Var a, b, c; a = (1 -3 - b) + 3 - 2;",
            "Var a, b; a = b; b = 23; c = (4-3);",
            "Var a, b, c; a = 5; b = a - 3 * 2; c = (4 - (3+2)) - a + (4 - 32) * 2;",
            "Var a, b, c; a = 5; b = (2 - (3 + 2) + 4;",
            "Var b; b = (2 - 3) + 2) + 4 - a;",
            "Var b; b = 2 + 3 = 5;",
            "Var ; c = 2;",
            "Var a,,g c = 2;",
            "Var a; b = a;",
            "Var b; b = 5; b = 5 + a;",
            "Var c, ab; c = ab; abc = 3;",
            "Var b, a; a = 5 + 2; b = (a + 3) - 4 * c;",
            "Var ab, c, d; ab = (5-3)+1+d; c = 5*d; c = ((dc * 2) + d) - 3 * d;"
        )
    }

    private fun test(vararg data: String) {
        data.forEachIndexed { i, str ->
            try {
                println("==================")
                println("Test $i: $str")
                val program = Program(str)
                println("Success")
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}