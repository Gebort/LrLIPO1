package program

import java.lang.Exception

class Operand(private val line: Int, private val data: String) {
    val ident: Ident?
    val constant: Constant?

    init {
        data.trim{it == ' ' }.let {
            ident = try {
                it.also { it.checkIdent(line) }
            } catch (e: Exception) {
                null
            }
            constant = try {
                it.toInt()
            } catch (e: Exception) {
                null
            }

            if (ident == null && constant == null) {
                throw Exception("Line $line: Operand must be ident or constant")
            }
        }

    }
}