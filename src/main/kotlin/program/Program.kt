package program

// <программа> ::= <объявление переменных> <описание вычислений>
class Program(private val data: String) {

    var varList: VarList
        private set
    var assignments: AssignmentsList
        private set

    init {
        val trimmedData = data.trim { it == ' ' }
        val splitData = trimmedData.split(' ')

        if (splitData.isEmpty()) {
            throw Exception("Empty program code")
        }
        if (splitData[0] != "Var") {
            throw Exception("Program must start with Var ")
        }
        val varListEnd = trimmedData.indexOfFirst { it == ';' }

        if (varListEnd == -1) {
            throw Exception("Var list must be separated with ;")
        }

        val varListString = trimmedData.substring(0, varListEnd)
        val assignmentsList = trimmedData.substring(varListEnd + 1, trimmedData.length)

        varList = VarList(varListString)
        assignments = AssignmentsList(assignmentsList)
    }

}