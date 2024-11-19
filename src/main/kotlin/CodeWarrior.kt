package ru.kdk

class CodeWarrior {
    /**
     * Codewars, 5 kyu
     *
     * Парсит формулу [formula] и возвращает кол-во молекул в формуле.
     * В формуле могут встречаться различные скобки (, {, [, означают умножение молекул внутри
     *
     * @param formula Строка с химической формулой, к примеру 'H2O'
     * @return Словарь ключ в котором молекулы, а значение - кол-во молекул в формуле, к примеру {H: 2, O: 1}
     */
    fun getAtoms(formula: String): Map<String, Int> {
        val subFormulaRegex = "(\\(\\w+\\)|\\{\\w+\\}|\\[\\w+\\])(\\d*)".toRegex()
        val moleculeRegex = "([A-Z][a-z]?)([1-9]*)".toRegex()

        val out = mutableMapOf<String, Int>()

        for (match in subFormulaRegex.findAll(formula)) {
            val (subFormula, count) = match.destructured

            for (match2 in moleculeRegex.findAll(subFormula)) {
                val (molecule, count2) = match.destructured

                out[molecule] = out.getOrDefault(molecule, 0) + (count2.toIntOrNull() ?: 1) * (count.toIntOrNull() ?: 1)
            }
        }



        /*
        var molecule = ""

        for (letter in formula) {
            if (letter.isLetter()) {
                molecule = molecule.plus(letter)
            }

            if (letter.isDigit()) {
                val num = letter.digitToInt()
                out[molecule] = out.getOrDefault(molecule, 0) + num
            }
        }
         */


        return out
    }

    /**
     * 6 kyu
     *
     * Дано: лотерейный билет (массив из пар строка и число) (ticket) и количество выйгрышных пар (win)
     *
     * Для начало надо подсчитать количество выйгрышных пар,
     * если количество выйгрышных пар больше или равно значению win то вернуть "Winner!", иначе "Loser!"
     *
     * Пара считается выигрышной если код хотя бы одна буква в строке соответствует числовому значению в паре
     */
    fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String =
        if (ticket.count { it.second.toChar() in it.first } >= win) "Winner!" else "Loser!"

    /**
     * 7 kyu
     *
     * На вход подаются массив чисел и максимальное количество вхождений отдельных чисел в выходной массив
     * Необходимо сформировать выходной массив без изменения исходного порядка чисел, но убрать неподходящие числа
     */
    fun deleteNth(elements: IntArray, maxOccurrences: Int): IntArray {
        val elementsMap = mutableMapOf<Int, Int>()

        return elements.filter {
            val occurrences = elementsMap.getOrDefault(it, 0)
            val res = occurrences < maxOccurrences
            elementsMap[it] = occurrences + 1
            return@filter res
        }.toIntArray()
    }
}
