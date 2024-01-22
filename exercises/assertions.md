# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer
1. Float values can't be compare with accuracy, the result can have a lot of digits after the decimal point. So it is
useless to compare exactly two Float values. In this case I would write  `assertEquals(3 * .4, 1.2, 0.1f)`, the third
parameter is a delta telling the assertion to check equality to this nearest value.
2. AssertEquals checks if two objects (different or not) are equals. AssertSame checks if two objects' reference point
to the same object in memory. For example :
`assertEquals("One string", "One string") and assertSame("One string", "One string")` will return true for both of them
because the assertEqual for String type will deeply check if two strings are equal and assertSame will compare the reference
of identical strings which here are declare as literal in memory (same memory address).
Now let's say we have this code :  
```
String str1 = new String("One String");
String str2 = new String("One String");

assertEquals(str1, str2);
assertSame(str1, str2);
```
Here assertEquals will return true because str1 and str2 are in fact equal.
But assertSame return false because the new keyword create a new memory address
for each variables str 1 and str2.
3. The `fail` keyword could be useful to check if an exception is thrown eventhough it shouldn't.
Another use case is when some values are not expected. Finally, `fail` could be use to check execution reach a certain
code line when it should have returned before. Let's write a example :
```
int value = 0;
boolean loop = false;

while (!loop){
    value++;
    if(value >= 5000) return;
    if(value >= 5001)
        fail("Max int value reach limit");
}
```
Here we don't want the int value to reach 5001, so we put a `fail` inside a condition to check if the value has reach the limit we fixed.
4. With assertThrows it is possible to check multiple exception within the same test case.