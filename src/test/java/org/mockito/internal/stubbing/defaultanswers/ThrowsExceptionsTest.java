package org.mockito.internal.stubbing.defaultanswers;

import org.junit.Test;
import org.mockito.internal.stubbing.defaultanswers.ThrowsExceptions.NotImplementedException;
import org.mockito.stubbing.Answer;
import org.mockitoutil.TestBase;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class ThrowsExceptionsTest extends TestBase {

    interface FooInterface {
        void fooMethod();
    }

    @Test
    public void should_throw_not_implemented_exception() throws Throwable {
        Answer<Object> answer = new ThrowsExceptions();
        try {
            answer.answer(invocationOf(FooInterface.class, "fooMethod"));
            fail("Expected NotImplementedException was not thrown.");
        } catch (NotImplementedException expected) {
        }
    }
}