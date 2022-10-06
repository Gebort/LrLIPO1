package program

// <объявление переменных> ::= Var <список переменных>;
// <список переменных> ::= <идент> | <идент>, <список переменных>
class VarList(private val data: String) {
    private val line = 1
    var vars = mutableListOf<Ident>()
        private set

    init {
        val trimmedData = data.removePrefix("Var")

        if (trimmedData.endsWith(',')) {
            throw Exception("Line $line: Remove the , from the declaration list end")
        }
        if (trimmedData.startsWith(',')) {
            throw Exception("Line $line: Remove the , from the declaration list start")
        }
        if (trimmedData.contains(Regex(",{2}"))) {
            throw Exception("Line $line: Missed variable in variables list")
        }

        trimmedData.split(',')
            .forEach { ident ->
                ident.checkIdent(line)
                vars.add(ident)
            }
    }

}