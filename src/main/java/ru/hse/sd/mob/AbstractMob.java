package ru.hse.sd.mob;


import ru.hse.sd.Coords;
import ru.hse.sd.Direction;
import ru.hse.sd.Game;
import ru.hse.sd.mob.action.MobAction;
import ru.hse.sd.mob.strategy.BehaviorStrategy;

/**
 * AbstractMob contains stats of mob and its "conditional strategy", i.e. AI of this mob.
 * <p/>
 * <b>Important</b>: <i>Mob knows nothing about current game state, position of player or its own position on map.
 * This things should be managed by controlling component.</i>
 */
public class AbstractMob {

    private String name;
    private int hp;
    private int damage;
    private int attackRadius;
    private int speed;
    private int aggroRadius;
    private Coords coords;

    private BehaviorStrategy strategy;



    /**
     * All fields constructor.
     * <p/>
     * Package private visibility modificator set intentionally.
     *
     * @param name         Mob's string name.
     * @param hp           Mob's hitpoints (health).
     * @param damage       Mob's damage per hit.
     * @param attackRadius Mob's attack radius.
     * @param speed        Mob's move speed.
     * @param coords       Mob's coords.
     */
    AbstractMob(String name, int hp, int damage, int attackRadius, int speed, int aggroRadius, Coords coords) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.attackRadius = attackRadius;
        this.speed = speed;
        this.aggroRadius = aggroRadius;
        this.coords = coords;
    }

    /**
     * AI of the Mob
     * Return "action" based on current game state, player position and its own position on map.
     */
    public MobAction decideAction(Game game) {
        return strategy.decideAction(game);
    }

    /**
     *
     * @param direction direction to move
     * @return new coords after move
     */
    private Coords coordsAfterMove(Direction direction) {
        return coords.moveByDelta(direction.getDx() * speed, direction.getDy() * speed);
    }

    /**
     *
     * @param coords new coords to move to
     */
    private void moveTo(Coords coords) {
        this.coords = coords;
    }

    /**
     *
     * @param coords target coords
     * @return if mob can aggro to target, i.e. sees target and can approach to it
     */
    public boolean canAggro(Coords coords) {
        return coords.distanceTo(this.coords) <= aggroRadius;
    }

    public boolean canAttack(Coords coords) {
        return coords.distanceTo(this.coords) <= attackRadius;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public MobAction moveAction(Direction direction) {
        return (game) -> {
            var targetCoors = coordsAfterMove(direction);
            if (game.availableToMoveCoords(targetCoors)) {
                moveTo(targetCoors);
            }
        };
    }

    public MobAction attackPlayerAction() {
        return (game) -> game.attackPlayer(damage);
    }

}
