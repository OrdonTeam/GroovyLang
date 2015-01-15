package nextstep

import groovy.transform.CompileStatic

@CompileStatic
class Box {
    Box innerBox

    Box getInnerBox() {
        return innerBox
    }




    static Box inner(int i) {
        Box box = new Box()
        i.times {
            box = new Box(innerBox: box)
        }
        return box
    }
}
