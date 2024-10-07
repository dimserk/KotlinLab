package ru.kdk

/**
 * codewars, 5 kyu
 *
 * Массив необходимо представить "постранично" и вернуть различную информацию о представлении
 *
 * @param[T] Тип данных [collection]
 * @property[collection] Коллекция элементов
 * @property[itemsPerPage] Кол-во элементов на одной странице
 */
class PaginationHelper<T>(private val collection: List<T>, private val itemsPerPage: Int) {

    // Можно было нарезать исходный массив
    // val chunks = collection.chunked(itemsPerPage)

    /**
     * Кол-во элементов на всех страницах
     */
    val itemCount = collection.size

    /**
     * Кол-во страниц
     */
    val pageCount: Int
        get() {
            val pages = collection.size / itemsPerPage
            return if (collection.size % itemsPerPage == 0) pages else pages + 1
        }


    /**
     * Определяет кол-во элементов на странице с заданным индексом [pageIndex]
     *
     * @param[pageIndex] Индекс страницы, может иметь недопустимое значение
     * @return Кол-во элементов на странице с индексом [pageIndex] или -1 в случе некорректного [pageIndex]
     */
    fun pageItemCount(pageIndex: Int): Int {
        if (pageIndex >= pageCount || pageIndex < 0)
            return -1

        if (collection.size < itemsPerPage || pageCount == 1)
            return collection.size

        if (pageIndex < pageCount - 1)
            return itemsPerPage

        return collection.size % itemsPerPage
    }


    /**
     * Возвращает индекс страницы, на которой находится элемент [collection] с индексом [itemIndex]
     *
     * @param[itemIndex] Индекс элемента коллекции [collection], может иметь недопустимое значение
     * @return Индекс страницы или -1 в случае некорректного [itemIndex]
     */
    fun pageIndex(itemIndex: Int): Int {
        if (itemIndex >= collection.size || itemIndex < 0)
            return -1

        return itemIndex / itemsPerPage
    }
}