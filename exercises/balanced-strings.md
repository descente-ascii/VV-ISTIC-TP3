# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy *Base Choice Coverage*. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer
1. In this problem it's possible to identify multiples characteristics and so multiple blocks.
    Characteristics  | Block
        Empty String | ""
        Blank String | " ", "   ", ...
        Unbalanced string with brackets only | "{)[", "((}}", "[]]}", ...
        Balanced string with brackets only | "{}", "[]", "()", "{[()]}", ...
        String without brackets | "aaa", "123456", ...
        Balanced String with brackets and non-bracket | "(abc)", "a{1[o]}", "{([0])}", ...
        Unbalanced String with brackets and non-bracket | "a{5)", "((abc]]", ...

2. I first wrote one test case per characteristics. The coverage indicates 100% of the function was reached, however one
case failed (unbalancedBrackets). My implementation was missing the case where the string only contains opening brackets.
This error fixed, I now get a full covered working function. Tho, I realise that my test cases may not be exhaustive.

3. Not answered

4. On the first PIT execution, I got 26 mutations and 21 were killed which gives me a mutation score of 81%.
On org.pitest.mutationtest.engine.gregor.mutators.BooleanTrueReturnValsMutator I got 5 NO_COVERAGE mutants.