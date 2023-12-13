package org.aalonso.SearchSuite;

import com.bst.BST;
import com.bst.Node;
import com.exceptions.DepthException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class SearchTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/searchSuiteResources/values.csv", numLinesToSkip = 1, lineSeparator = "\n", delimiter = ',')
    public void testSearchLimitValues(int content) throws DepthException {
        BST<Integer> tree;
        if (content >= -2500 && content <= 2500) {
            tree = new BST<Integer>(content);
            Node<Integer> node = tree.search(content);
            assertNotNull(node);
        } else {
            tree = new BST<Integer>();
            assertThrows(IllegalArgumentException.class, () -> tree.insert(content, false));
            assertNull(tree.search(content));
        }
    }
}
