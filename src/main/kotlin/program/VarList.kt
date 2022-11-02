package program

// <объявление переменных> ::= Var <список переменных>;
// <список переменных> ::= <идент> | <идент>, <список переменных>
class VarList(private val data: String) {
    var vars = mutableListOf<Ident>()
        private set

    init {
        try {
            val trimmedData = data.removePrefix("Var")

            if (trimmedData.endsWith(',')) {
                throw Exception("Remove the , from the declaration list end")
            }
            if (trimmedData.startsWith(',')) {
                throw Exception("Remove the , from the declaration list start")
            }
            if (trimmedData.contains(Regex(",{2}"))) {
                throw Exception("Missed variable")
            }

            trimmedData.split(',')
                .forEach { ident ->
                    val trimmed = ident.trim()
                    trimmed.checkIdent()
                    vars.add(trimmed)
                }
        } catch (e: Exception) {
            throw (Exception("Line 1: ${e.message}"))
        }
    }

    fun toTarget(): String {
        return "Var " + vars.joinToString(separator = ", ")
    }

}