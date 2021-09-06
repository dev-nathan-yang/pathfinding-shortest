package algorithms;


import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTest
{
    @Test
    public void whenPushToStackThenShouldRetrieveIt() {
        //Given stack
        Stack<String> stack = new Stack<>();

        //When
        stack.push("a");

        //Then
        assertEquals(1, stack.size());

        //Then
        String element = stack.pop();
        assertEquals("a", element);
        assertEquals(true, stack.isEmpty());
    }

}
