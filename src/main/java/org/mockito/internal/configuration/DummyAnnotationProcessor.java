/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.configuration;

import org.mockito.Dummy;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.defaultanswers.ThrowsExceptions;

import java.lang.reflect.Field;

/**
 * Instantiates a mock on a field annotated by {@link org.mockito.Dummy}
 */
public class DummyAnnotationProcessor implements FieldAnnotationProcessor<Dummy> {
    public Object process(Dummy annotation, Field field) {
        MockSettings mockSettings = Mockito.withSettings();
        if ("".equals(annotation.name())) {
            mockSettings.name(field.getName());
        } else {
            mockSettings.name(annotation.name());
        }
        mockSettings.defaultAnswer(new ThrowsExceptions());
        return Mockito.mock(field.getType(), mockSettings);
    }
}
