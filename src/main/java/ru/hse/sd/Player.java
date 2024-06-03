package ru.hse.sd;

import ru.hse.sd.actions.interfaces.InventoryArtifact;
import ru.hse.sd.exceptions.InventoryIsFull;
import ru.hse.sd.exceptions.NonExistentArtifactId;
import ru.hse.sd.exceptions.PlayerIsAlreadyDead;

import java.util.*;
import java.util.stream.IntStream;

public class Player {
    private int hp;
    private int damage;
    private int attackRadius;
    private Coords coordinates;
    // key of map is ID. User can access element with ID 'i' by pressing the corresponding key button
    // We also support an invariant: entry exists in map <=> artifact is valid
    private final Map<Integer, InventoryArtifact> inventory = new HashMap<>();
    private final Set<Integer> freeInventorySlots = new HashSet<>();

    public Player(int defaultHp) {
        this.hp = defaultHp;
        IntStream.rangeClosed(0, 9).forEach(freeInventorySlots::add);
    }

    public void increaseHp(int delta) {
        // DO NOTHING IF DEAD
        hp = Math.max(hp + delta, 0);
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void kill() {
        hp = 0;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttackRadius(int attackRadius) {
        this.attackRadius = attackRadius;
    }

    public void useArtifact(int artifactId) throws NonExistentArtifactId, PlayerIsAlreadyDead {
        InventoryArtifact entry = inventory.get(artifactId);
        if (entry == null) {
            throw new NonExistentArtifactId(String.format("Artifact with id %d does not exist", artifactId));
        }

        entry.use(this);

        if (!entry.isPermanent()) {
            removeArtifact(artifactId);
        }
    }

    public void takeArtifact(InventoryArtifact artifact) throws InventoryIsFull {
        Optional<Integer> freeSlot = freeInventorySlots.stream().findFirst();
        if (freeSlot.isEmpty()) {
            throw new InventoryIsFull("Inventory is full");
        }
        freeInventorySlots.remove(freeSlot.get());
        inventory.put(freeSlot.get(), artifact);
    }

    public Coords getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coords coordinates) {
        this.coordinates = coordinates;
    }

    private void removeArtifact(int artifactId) {
        freeInventorySlots.add(artifactId);
        inventory.remove(artifactId);
    }
}
