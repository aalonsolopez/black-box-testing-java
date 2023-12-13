package org.aalonso.PrintBetweenLevelSuite;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.bst.BST;
import com.exceptions.BetweenLevelException;
import com.exceptions.DepthException;

public class PrintBetweenLevelTest {

    private static BST<Integer> bst;

    @AfterAll
    public static void tearDown() {
        bst = null;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/printBetweenLevelSuiteResources/values.csv", numLinesToSkip = 1, lineSeparator = "\n", delimiter = ',')
    public void testPrintBetweenLevel(int a, int b) throws DepthException, BetweenLevelException {
        bst = new BST<Integer>(a);
        if (a != b) {
            bst.insert(b, false);
        }

        int baseElement = 89;

        for (int i = bst.depth(); i < 50; i++) {
            bst.insert(baseElement++, false);
        }
        
        if (a > b) {
            assertThrows(BetweenLevelException.class, () -> bst.printBetweenLevel(a, b));
        } else if (a >= 50 || b >= 50 || a <= 0 || b <= 0){
            assertThrows(DepthException.class, () -> bst.printBetweenLevel(a, b));
        } else {
            List<Integer> list = bst.printBetweenLevel(a, b);
            assertNotNull(list);
            assertEquals(a, list.get(0));
            if (a != b) {
                assertEquals(b, list.get(1));
                assertEquals(2, list.size());
            } else {
                assertEquals(1, list.size());
            }
        } 
    }
}
