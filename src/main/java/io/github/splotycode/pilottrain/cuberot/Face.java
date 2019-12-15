package io.github.splotycode.pilottrain.cuberot;

import io.github.splotycode.mosaik.util.collection.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Face {

    TOP {
        @Override
        public Face calcNewFace(Direction direction) {
            return direction.toFace();
        }
    },
    BOTTOM(TOP) {
        @Override
        public Face calcNewFace(Direction direction) {
            return direction.toFace().opposite;
        }
    },
    LEFT {
        @Override
        public Face calcNewFace(Direction direction) {
            switch (direction) {
                case RIGHT:
                    return TOP;
                case LEFT:
                    return BOTTOM;
                default:
                    return this;
            }
        }
    },
    RIGHT(LEFT) {
        @Override
        public Face calcNewFace(Direction direction) {
            switch (direction) {
                case RIGHT:
                    return BOTTOM;
                case LEFT:
                    return TOP;
                default:
                    return this;
            }
        }
    },
    BACK {
        @Override
        public Face calcNewFace(Direction direction) {
            switch (direction) {
                case FRONT:
                    return TOP;
                case BACK:
                    return BOTTOM;
                default:
                    return this;
            }
        }
    },
    FRONT(BACK) {
        @Override
        public Face calcNewFace(Direction direction) {
            switch (direction) {
                case FRONT:
                    return BOTTOM;
                case BACK:
                    return TOP;
                default:
                    return this;
            }
        }
    };

    private Face opposite;

    Face(Face opposite) {
        this.opposite = opposite;
        opposite.opposite = this;
    }

    public abstract Face calcNewFace(Direction direction);

    public static Face getRandom() {
        return ArrayUtil.pick(values());
    }

}
