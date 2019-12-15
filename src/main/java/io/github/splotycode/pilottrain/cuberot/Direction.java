package io.github.splotycode.pilottrain.cuberot;

import io.github.splotycode.mosaik.util.collection.ArrayUtil;

public enum  Direction {

    BACK,
    FRONT,
    RIGHT,
    LEFT;

    public static Direction getRandom() {
        return ArrayUtil.pick(values());
    }

    public Face toFace() {
        return Face.valueOf(name());
    }

}
