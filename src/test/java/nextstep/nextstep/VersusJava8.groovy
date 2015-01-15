package nextstep.nextstep

import nextstep.MyClass
import org.junit.Test

import static org.fest.assertions.api.Assertions.assertThat

class VersusJava8 {
    class Tips {
        int tips = 1

        public <T> T useTip(Closure<T> closure) {
            if (tips) {
                tips--
                return closure()
            }
            return null
        }
    }

    @Test
    public void shouldExecuteOnlyFirstCall() throws Exception {
        Tips tips = new Tips()
        String first = tips.useTip {
            return 'it works at first time'
        }
        MyClass second = tips.useTip {
            //but not twice
            return new MyClass()
        }
        assertThat(first).isEqualTo('it works at first time')
        assertThat(second).isNull()
    }
}
