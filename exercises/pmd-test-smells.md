# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Using pmd on Apache Commons Math and focusing on rule **JUnitUseExpected.md**. I found a warning on
**commons-math\commons-math-legacy\src\test\java\org\apache\commons\math4\legacy\fitting\leastsquares\AbstractLeastSquaresOptimizerAbstractTest.java:341**
  
The annotation test should be `@Test(expected=Exception.class)` instead of `@Test`
```
@Test
    public void testInconsistentSizes1() {
        try {
            LinearProblem problem
                    = new LinearProblem(new double[][]{{1, 0},
                    {0, 1}},
                    new double[]{-1, 1});

            //TODO why is this part here? hasn't it been tested already?
            Optimum optimum = optimizer.optimize(problem.getBuilder().build());

            Assert.assertEquals(0, optimum.getRMS(), TOL);
            assertEquals(TOL, optimum.getPoint(), -1, 1);

            //TODO move to builder test
            optimizer.optimize(
                    problem.getBuilder().weight(new DiagonalMatrix(new double[]{1})).build());

            fail(optimizer);
        } catch (DimensionMismatchException e) {
            //expected
        }
    }
```