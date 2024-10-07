package ru.kdk

class CodeWarrior {
    /**
     * codewars, 5 kyu
     *
     * Парсит формулу [formula] и возвращает кол-во молекул в формуле.
     * В формуле могут встречаться различные скобки (, {, [, означают умножение молекул внутри
     *
     * @param formula Строка с химической формулой, к примеру 'H2O'
     * @return Словарь ключ в котором молекулы, а значение - кол-во молекул в формуле, к примеру {H: 2, O: 1}
     */
    fun getAtoms(formula: String): Map<String, Int> {

        //val brackets = "(){}[]"

        val out = mutableMapOf<String, Int>()

        val regex = "([A-Z][a-z]?)([1-9]*)".toRegex()
        for (match in regex.findAll(formula)) {
            val (molecula, count) = match.destructured

            out[molecula] = out.getOrDefault(molecula, 0) + (count.toIntOrNull() ?: 1)
        }

        /*
        var molecula = ""

        for (letter in formula) {
            if (letter.isLetter()) {
                molecula = molecula.plus(letter)
            }

            if (letter.isDigit()) {
                val num = letter.digitToInt()
                out[molecula] = out.getOrDefault(molecula, 0) + num
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
     * Пара считается выйгрышной если код хотябы одна буква в строке соответствует числовому значению в паре
     */
    fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String =
        if (ticket.count { it.second.toChar() in it.first } >= win) "Winner!" else "Loser!"

    /**
     * 7 kyu
     *
     * На вход подаются массив чисел и максимальное количество вхождений отдельных числе в выходной массив
     * Необходимо сформировать выходной массив без изменения исходного порядка чисел, но убрать неподходящие числа
     */
    fun deleteNth(elements: IntArray, maxOcurrences: Int): IntArray {
        val elementsMap = mutableMapOf<Int, Int>()

        return elements.filter {
            val ocurrences = elementsMap.getOrDefault(it, 0)
            val res = ocurrences < maxOcurrences
            elementsMap[it] = ocurrences + 1
            return@filter res
        }.toIntArray()
    }
}
