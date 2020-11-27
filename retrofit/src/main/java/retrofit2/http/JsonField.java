package retrofit2.http;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import retrofit2.Retrofit;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Named pair for a JsonEncoded request.
 * <p>
 * Values are converted to strings using {@link Retrofit#stringConverter(Type, Annotation[])}
 * (or {@link Object#toString()}, if no matching string converter is installed)
 * and then form URL encoded.
 * {@code null} values are ignored. value's type can only be raw type.
 * <p>
 * Simple Example:
 * <pre><code>
 * &#64;JsonEncoded
 * &#64;POST("/login")
 * Call&lt;ResponseBody&gt; login(
 *     &#64;JsonField("username") String username,
 *     &#64;JsonField("password") String password);
 * </code></pre>
 * Calling with {@code foo.example("Bob Smith", "President")} yields a request body of
 * {@code {'password':'Bob Smith','password':'President'}}.
 * <p>
 *
 * @see JsonEncoded
 */
@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface JsonField {
    /** The JsonEncoded filed name. */
    String value();
}