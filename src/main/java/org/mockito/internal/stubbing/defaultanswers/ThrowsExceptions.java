/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.stubbing.defaultanswers;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.Serializable;

/**
 * Optional Answer that can be used with {@link Mockito#mock(Class, Answer)}. It
 * is used by {@link Mockito#dummy(Class)}.
 * <p>This implementation throws an exception whenever a method of the mock is
 * called. This is helpful if you want to ensure that a dummy object (according
 * to Meszaros) is only passed around and never used.</p>
 * @since 2.0.31
 */
public class ThrowsExceptions implements Answer<Object>, Serializable {

    private static final long serialVersionUID = 3585876470101750917L;

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        throw new NotImplementedException();
    }

    static class NotImplementedException extends RuntimeException {
    }
}
