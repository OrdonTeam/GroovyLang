import org.junit.Test

import static org.fest.assertions.api.Assertions.assertThat

class Strings {




    @Test
    public void buildingStringsInJava() throws Exception {
        int a=0,b=1,c=2;
        String text = "a=" + a + " b=" + b + " c=" + c

        assertThat(text).isEqualTo("a=0 b=1 c=2")
    }








    @Test
    public void buildingStringsInGroovy() throws Exception {
        int a=0,b=1,c=2;
        String text = "a=$a b=$b c=$c"

        assertThat(text).isEqualTo("a=0 b=1 c=2")
    }
}
