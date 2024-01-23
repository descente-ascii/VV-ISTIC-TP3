package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    String emptyString = "";
    String blankString = "   ";
    String unbalancedBrackets = "[("; //<-- open closed --> "[])"
    String balancedBrackets = "[{()}]";
    String noBrackets = "abcd1234";
    String balancedBracketsAndNoBrackets = "a{1[o]}";
    String unbalancedBracketsAndNoBrackets = "([abc]}";


    @Test public void testEmptyString() {
        assertTrue(StringUtils.isBalanced(emptyString));
    }

    @Test public void testBlankString() {
        assertTrue(StringUtils.isBalanced(blankString));
    }

    @Test public void testUnbalancedWBrackets() {
        assertFalse(StringUtils.isBalanced(unbalancedBrackets));
    }

    @Test public void testBalancedWBrackets() {
        assertTrue(StringUtils.isBalanced(balancedBrackets));
    }

    @Test public void testNoBrackets() {
        assertTrue(StringUtils.isBalanced(noBrackets));
    }

    @Test public void testBalancedBracketsAndNoBrackets() {
        assertTrue(StringUtils.isBalanced(balancedBracketsAndNoBrackets));
    }

    @Test public void testUnbalancedBracketsAndNoBrackets() {
        assertFalse(StringUtils.isBalanced(unbalancedBracketsAndNoBrackets));
    }
}