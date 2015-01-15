package nextstep

import groovy.transform.CompileStatic
import org.junit.Test

import static org.fest.assertions.api.Assertions.assertThat

@CompileStatic
class ElvisAndSafeNull {
    private String java(String name) {
        return name != null ? name : "Unknown";
    }
    private String groovy(String name) {
        return name ? name : 'Unknown'
    }
    private String GROOVY(String name) {
        return name ?: 'Unknown'
    }

    @Test
    public void javaGroovyGROOVY() throws Exception {
        String name = 'name';
        String nullName = null

        assertThat(java(name)).isEqualTo('name')
        assertThat(groovy(name)).isEqualTo('name')
        assertThat(GROOVY(name)).isEqualTo('name')
        assertThat(java(nullName)).isEqualTo('Unknown')
        assertThat(groovy(nullName)).isEqualTo('Unknown')
        assertThat(GROOVY(nullName)).isEqualTo('Unknown')
    }

    @Test
    public void ifNullJava() throws Exception {
        assert getInnerInnerInnerBox_Java(null) == null
        assert getInnerInnerInnerBox_Java(Box.inner(0)) == null
        assert getInnerInnerInnerBox_Java(Box.inner(1)) == null
        assert getInnerInnerInnerBox_Java(Box.inner(2)) == null
        assert getInnerInnerInnerBox_Java(Box.inner(3)) != null
    }

    private Box getInnerInnerInnerBox_Java(Box box) {
        if (box == null)
            return null;
        Box inner = box.getInnerBox();
        if(inner == null)
            return null;
        Box innerInner = inner.getInnerBox();
        if(innerInner == null)
            return null;
        return innerInner.getInnerBox();
    }

    @Test
    public void ifNullGroovy() throws Exception {
        assert getInnerInnerInnerBox_Groovy(null) == null
        assert getInnerInnerInnerBox_Groovy(Box.inner(0)) == null
        assert getInnerInnerInnerBox_Groovy(Box.inner(1)) == null
        assert getInnerInnerInnerBox_Groovy(Box.inner(2)) == null
        assert getInnerInnerInnerBox_Groovy(Box.inner(3)) != null
    }

    Box getInnerInnerInnerBox_Groovy(Box box) {
        box?.getInnerBox()?.innerBox?.innerBox
    }
}
