package org.aalonso.InsertSuite;

import com.bst.BST;
import com.bst.Node;

import com.exceptions.DepthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class InsertTest {
    BST<Integer> tree;
    @ParameterizedTest
    @CsvFileSource(resources = "./values.csv", numLinesToSkip = 1, lineSeparator = "\n", delimiter = ',')

    @BeforeEach
    public void setUp() {
        tree = new BST();
    }

    public void insertValuesTillDepth(BST<Integer> tree, int depth, boolean recursive) throws DepthException {
        for (int i = 0; i < depth - 1; i++) {
            tree.insert(i, recursive);
        }
    }

    @Test
    public void testInsert() throws DepthException {
        // TODO: Add test
    }
}
