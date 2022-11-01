package program

import java.lang.Exception

class Operand(private val data: String) {
    val ident: Ident?
    val constant: Constant?

    init {
        data.trim{it == ' ' }.let {
            ident = try {
                it.trim().also { it.checkIdent() }
            } catch (e: Exception) {
                null
            }
            constant = try {
                it.toInt()
            } catch (e: Exception) {
                null
            }

            if (ident == null && constant == null) {
                throw Exception("Operand must be ident or constant")
            }
        }

    }
}