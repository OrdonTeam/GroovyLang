package nextstep.nextstep;

import nextstep.MyClass;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class VersusJava8Java {
    public class Tips{
        int tips = 1;
        public <T>T useTip(TipCall<T> tipCall){
            if(tips>0){
                tips--;
                return tipCall.call();
            }
            return null;
        }
    }
    public interface TipCall<T>{
        T call();
    }

    @Test
    public void shouldExecuteOnlyFirstCall() throws Exception {
        Tips tips = new Tips();
        String first = tips.useTip(new TipCall<String>() {
            @Override
            public String call() {
                return "it works at first time";
            }
        });
        MyClass second = tips.useTip(new TipCall<MyClass>() {
            @Override
            public MyClass call() {
                return new MyClass();
            }
        });
        assertThat(first).isEqualTo("it works at first time");
        assertThat(second).isNull();
    }

    @Test
    public void shouldExecuteOnlyFirstCallWithLambdas() throws Exception {
        Tips tips = new Tips();
        String first = tips.useTip(()->
                "it works at first time"
        );
        MyClass second = tips.useTip(() ->
                new MyClass()
        );
        assertThat(first).isEqualTo("it works at first time");
        assertThat(second).isNull();
    }
}
