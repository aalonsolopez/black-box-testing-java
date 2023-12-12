package org.aalonso.InsertSuite;

import com.bst.BST;
import com.bst.Node;
import com.exceptions.DepthException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;


public class InsertTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/values.csv", numLinesToSkip = 1, lineSeparator = "\n", delimiter = ',')
    public void testInsertLimitValues(int content, boolean recursive, int depth) throws DepthException {
        BST<Integer> tree = new BST<Integer>();
        if (content >= -2500 && content <= 2500) {
            tree.insert(content, false);
            Node<Integer> node = tree.search(content);
            assertNotNull(node);
        } else {
            assertThrows(IllegalArgumentException.class, () -> tree.insert(content, false));
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/values.csv", numLinesToSkip = 1, lineSeparator = "\n", delimiter = ',')
    public void testInsertLimitDepth(int content, boolean recursive, int depth) throws DepthException {
        BST<Integer> tree = new BST<Integer>();
        int startingValue = 0;
        for (int i = 0; i < depth - 1; i++) {
            tree.insert(startingValue++, recursive);
        }
        if (tree.depth() >= 50) {
            assertThrows(DepthException.class, () -> tree.insert(2500, recursive));
        } else {
            tree.insert(2500, recursive);
            Node<Integer> node = tree.search(2500);
            assertNotNull(node);
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void testInsertOtherValueNotInteger(boolean recursive) throws DepthException {
        BST<String> tree = new BST<>();
        
        assertThrows(IllegalArgumentException.class, () -> tree.insert("hola", true));
    }
}
