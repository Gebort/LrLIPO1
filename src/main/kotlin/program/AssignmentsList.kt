package program

// <описание вычислений> ::= <список присваиваний>
// <список присваиваний> ::= <присваивание> | <присваивание> <список присваиваний>
class AssignmentsList(private val data: String) {

    var assignments = mutableListOf<Assignment>()
        private set

    init {
        val trimmedData = data.trim{ it == ' ' }

        if (trimmedData.last() != ';') {
            throw Exception("Program must end with ;")
        }
        trimmedData
            .removeSuffix(";")
            .split(';')
            .forEachIndexed { i, assign ->
                try {
                assignments.add(Assignment(assign))
                } catch (e: Exception) {
                    throw Exception("Line ${i+2}: ${e.message}")
                }
        }

    }

}