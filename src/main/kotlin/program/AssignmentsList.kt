package program

// <описание вычислений> ::= <список присваиваний>
// <список присваиваний> ::= <присваивание> | <присваивание> <список присваиваний>
class AssignmentsList(private val data: String, vars: Collection<Ident>) {

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
                    val ass = Assignment(assign)
                    checkIdents(ass, vars)
                    assignments.add(ass)
                } catch (e: Exception) {
                    throw Exception("Line ${i+2}: ${e.message}")
                }
            }
    }

    private fun checkIdents(ass: Assignment, vars: Collection<Ident>) {
        if (!vars.contains(ass.ident)) {
            throw Exception("Undefined variable - ${ass.ident}")
        }
        checkIdents(ass.expression.subExpression, vars)
    }
    private fun checkIdents(subExp: SubExpression, vars: Collection<Ident>) {
        subExp.expression?.subExpression?.let { checkIdents(it, vars) }
        subExp.subExpression1?.let { checkIdents(it, vars) }
        subExp.subExpression2?.let { checkIdents(it, vars) }
        subExp.operand?.ident?.let {
            if (!vars.contains(it)) {
                throw Exception("Undefined variable - $it")
            }
        }
    }

    fun toTarget(): String {
        return assignments
            .map { it.toTarget() }
            .joinToString(prefix = "Begin ", separator = " ", postfix = " End")
    }
}