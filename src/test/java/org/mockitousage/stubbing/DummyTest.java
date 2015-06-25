package org.mockitousage.stubbing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Dummy;
import org.mockitoutil.TestBase;

import static org.mockito.Mockito.dummy;

public class DummyTest extends TestBase {

    private Foo dummy;

    @Before
    public void setup() {
        dummy = dummy(Foo.class);
    }

    interface Foo {
        void fooMethod();
    }

    private static class FooConsumer {
        private final Foo foo;

        FooConsumer(Foo foo) {
            if (foo == null) {
                throw new NullPointerException("No FooInterface provide.");
            }
            this.foo = foo;
        }

        void act() {
            foo.fooMethod();
        }
    }

    @Test
    public void may_be_passed_around() {
        new FooConsumer(dummy);
    }

    @Test
    public void throws_exception_if_used() {
        FooConsumer consumer = new FooConsumer(dummy);
        try {
            consumer.act();
            fail("Expected exception has not been thrown.");
        } catch (RuntimeException expected) {
        }
    }
}
