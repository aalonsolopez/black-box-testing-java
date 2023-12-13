package org.aalonso.SearchSuite;

import com.bst.BST;
import com.bst.Node;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class SearchTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/searchSuiteResources/values.csv", numLinesToSkip = 1, lineSeparator = "\n", delimiter = ',')
    public void testSearchLimitValues(int content) {
        BST<Integer> tree = (content >= -2500 && content <= 2500) ? new BST<Integer>(content) : new BST<Integer>();
        if (content >= -2500 && content <= 2500) {
            Node<Integer> node = tree.search(content);
            assertNotNull(node);
        } else {
            assertNull(tree.search(content));
        }
    }
}
