package ru.hse.sd.mob;

import ru.hse.sd.Coords;

public interface AbstractMobFactory {
    /**
     * @return new AbstractMob instance
     */
    AbstractMob spawn(Coords coords);
}
