/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito;

import org.mockito.junit.MockitoJUnit;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Mark a field as a dummy.
 *
 * <ul>
 * <li>Allows shorthand dummy creation.</li>
 * <li>Minimizes repetitive dummy creation code.</li>
 * <li>Makes the test class more readable.</li>
 * <li>Makes the verification error easier to read because the <b>field name</b> is used to identify the dummy.</li>
 * </ul>
 *
 * <p>
 * Example:
 *
 * <pre class="code"><code class="java">
 * public class Test{
 *    &#64;Dummy Foo fooDummy;
 *
 *    &#64;Before
 *    public void init(){
 *       MockitoAnnotations.initMocks(this);
 *    }
 *    ...
 * }
 * </code></pre>
 * <p>
 * Same as doing:
 *
 * <pre class="code"><code class="java">
 * Foo fooDummy = Mockito.dummy(Foo.class);
 * </code></pre>
 *
 * <p>
 * <strong><code>MockitoAnnotations.initMocks(this)</code></strong> method has
 * to be called to initialize annotated objects. In above example,
 * <code>initMocks()</code> is called in &#064;Before (JUnit4) method. For
 * JUnit3 <code>initMocks()</code> can go to <code>setup()</code> method of a
 * base class. <strong>Instead</strong> you can also put initMocks() in your
 * JUnit rule (&#064;Rule) or runner (&#064;RunWith) or use the built-in
 * {@link MockitoJUnit#rule()} or {@link org.mockito.runners.MockitoJUnitRunner}.
 *
 * @see Mockito#dummy(Class)
 * @see Mock
 * @see Spy
 * @see InjectMocks
 * @see MockitoAnnotations#initMocks(Object)
 * @see org.mockito.runners.MockitoJUnitRunner
 * @see MockitoJUnit#rule()
 * @since 2.0.31
 */
@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface Dummy {

    String name() default "";
}
