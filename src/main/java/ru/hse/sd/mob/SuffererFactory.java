package ru.hse.sd.mob;

import ru.hse.sd.Coords;

public class SuffererFactory implements AbstractMobFactory {
    @Override
    public AbstractMob spawn(Coords coords) {
        return new AbstractMob(
                "Sufferer",
                100,
                10,
                1,
                2,
                20,
                coords
        );
    }
}
