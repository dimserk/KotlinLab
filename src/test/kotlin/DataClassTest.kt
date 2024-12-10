import org.junit.jupiter.api.Test
import ru.kdk.DataClass
import kotlin.test.assertEquals
import kotlin.test.fail

class DataClassTest {
    @Test
    fun firstTestCase() {
        val dataClass = DataClass(
            name = "Internet",
            parameters = arrayOf(1, 2, 3, 4, 5),
            blob = byteArrayOf(11, 12, 13, 14)
        )

        val bytes = dataClass.toByteArray() ?: fail()
        val secondDataClass = DataClass.fromByteArray(bytes)

        assertEquals(dataClass, secondDataClass)
    }
}