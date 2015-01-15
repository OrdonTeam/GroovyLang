package nextstep

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.junit.Test

import static org.fest.assertions.api.Assertions.assertThat

@CompileStatic
class Closures {
    @Test
    public void closures() throws Exception {
        Closure<String> closure = {
            return 'This is closure'
        }
        assertThat(closure()).isEqualTo('This is closure')
    }

    @Test
    public void returnIsOptional() throws Exception {
        Closure<String> closure = {
            'Return is optional'
        }
        assertThat(closure()).isEqualTo('Return is optional')
    }

    @Test
    public void closureCanTakeParameters() throws Exception {
        Closure<String> toUppercase = { String text ->
            text.toUpperCase()
        }
        assertThat(toUppercase('lower_case')).isEqualTo('LOWER_CASE')
    }

    private String execute(Closure<String> closure){
        closure('execute on this')
    }

    @Test
    public void passClosureAsParameter() throws Exception {
        Closure<String> toUppercase = { String text ->
            text.toUpperCase()
        }
        assertThat(execute(toUppercase)).isEqualTo('EXECUTE ON THIS')
    }

    private String toLowerCase(String text){
        text.toLowerCase()
    }

    @Test
    public void closureFromMethod() throws Exception {
        Closure<String> closure = this.&toLowerCase
        assertThat(closure('UPPER CASE')).isEqualTo('upper case')
    }

}
