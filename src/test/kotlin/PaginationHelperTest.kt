import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.kdk.PaginationHelper

class PaginationHelperTest {
    @Test
    fun firstTest() {
        val helper = PaginationHelper(listOf(1,2,3,4,5,6,7,8,9,10,11), 3)
        assertEquals(11, helper.itemCount)

        assertEquals(4, helper.pageCount)

        assertEquals(-1, helper.pageItemCount(-1))
        assertEquals(3, helper.pageItemCount(0))
        assertEquals(3, helper.pageItemCount(1))
        assertEquals(3, helper.pageItemCount(2))
        assertEquals(2, helper.pageItemCount(3))
        assertEquals(-1, helper.pageItemCount(4))

        assertEquals(-1, helper.pageIndex(-1))
        assertEquals(0, helper.pageIndex(0))
        assertEquals(2, helper.pageIndex(7))
        assertEquals(3, helper.pageIndex(10))
        assertEquals(-1, helper.pageIndex(11))
    }

    @Test
    fun secondTest() {
        val helper = PaginationHelper(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)

        assertEquals(6, helper.itemCount)

        assertEquals(2, helper.pageCount)

        assertEquals(4, helper.pageItemCount(0))
        assertEquals(2, helper.pageItemCount(1))

        assertEquals(0, helper.pageIndex(0))
        assertEquals(0, helper.pageIndex(3))
        assertEquals(1, helper.pageIndex(4))
        assertEquals(1, helper.pageIndex(5))
    }

    @Test
    fun thirdTest() {
        val helper = PaginationHelper(listOf(1, 2, 3, 4), 4)

        assertEquals(1, helper.pageCount)

        assertEquals(4, helper.pageItemCount(0))
    }
}