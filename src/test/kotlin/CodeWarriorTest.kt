import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.kdk.CodeWarrior

class CodeWarriorTest {

    private val warrior = CodeWarrior()

    @Test
    fun getAtomsTest() {
        assertEquals(mapOf("H" to 2, "O" to 1), warrior.getAtoms("H2O"))
        assertEquals(mapOf("C" to 6, "H" to 12, "O" to 6), warrior.getAtoms("C6H12O6"))
        assertEquals(mapOf("B" to 2, "H" to 6), warrior.getAtoms("B2H6"))
        assertEquals(mapOf("Mo" to 1, "C" to 6, "O" to 6), warrior.getAtoms("Mo(CO)6"))
        assertEquals(mapOf("Mg" to 1, "O" to 2, "H" to 2), warrior.getAtoms("Mg(OH)2"))
        assertEquals(mapOf("Fe" to 1, "C" to 10, "H" to 10), warrior.getAtoms("Fe(C5H5)2"))
        assertEquals(mapOf("C" to 8, "H" to 8, "Fe" to 1), warrior.getAtoms("(C5H5)Fe(CO)2CH3"))
        // Pd[P(C6H5)3]4
        // K4[ON(SO3)2]2
        // As2{Be4C5[BCo3(CO2)3]2}4Cu5
        // {[Co(NH3)4(OH)2]3Co}(SO4)3
        // C2H2(COOH)2
        // {((H)2)[O]}
        // Au5(C2H5[OH)3Li]3 exception
    }


    @Test
    fun bingoTest() {
        assertEquals("Loser!", warrior.bingo(arrayOf("ABC" to 65, "HGR" to 74, "BYHT" to 74), 2))
        assertEquals("Winner!", warrior.bingo(arrayOf("ABC" to 65, "HGR" to 74, "BYHT" to 74), 1))
        assertEquals("Loser!", warrior.bingo(arrayOf("HGTYRE" to 74, "BE" to 66, "JKTY" to 74), 3))
        assertEquals("Loser!", warrior.bingo(arrayOf("ABA" to 65, "AB" to 74), 2))
    }

    @Test
    fun deleteNthTest() {
        assertArrayEquals(
            intArrayOf(20, 37, 21),
            warrior.deleteNth(intArrayOf(20, 37, 20, 21), 1)
        )
        assertArrayEquals(
            intArrayOf(1, 1, 3, 3, 7, 2, 2, 2),
            warrior.deleteNth(intArrayOf(1, 1, 3, 3, 7, 2, 2, 2, 2), 3)
        )
        assertArrayEquals(
            intArrayOf(1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5),
            warrior.deleteNth(intArrayOf(1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1), 3)
        )
        assertArrayEquals(
            intArrayOf(1, 1, 1, 1, 1),
            warrior.deleteNth(intArrayOf(1, 1, 1, 1, 1), 5)
        )
        assertArrayEquals(
            intArrayOf(),
            warrior.deleteNth(intArrayOf(), 5)
        )
    }
}