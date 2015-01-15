package nextstep

import groovy.transform.CompileStatic
import org.junit.Test

import static org.fest.assertions.api.Assertions.assertThat

class FileOperations {

    @Test
    public void fileWriting() throws Exception {
        File file = new File("aaaa")
        List<String> input = ['aaaa', 'bbbb']
        List<String> output = []
        file.createNewFile()
        file.withWriter { writer ->
            input.each {
                writer.println(it)
            }
        }
        file.withReader { reader ->
            reader.eachLine {
                output.add(it)
            }
        }
        file.delete()
        assertThat(output).isEqualTo(input)
    }
}
