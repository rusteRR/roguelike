package ru.hse.sd.mob;

import ru.hse.sd.Coords;

public class GoonerFactory implements AbstractMobFactory {
    @Override
    public AbstractMob spawn(Coords coords) {
        return new AbstractMob(
                "Gooner",
                200,
                30,
                2,
                1,
                10,
                coords
        );
    }
}
