package cz.osu;

/**
 * Player in the Hangman game.
 */
public class Player {

    /**
     * The name of the player.
     */
    private String name;

    /**
     * The amount of all lifes of the player.
     */
    private int lifeAmount;

    /**
     * Creates a player with a name and life amount.
     * @param name The name of a player.
     * @param lifeAmount The life amount of a player.
     */
    public Player(String name, int lifeAmount) {
        this.name = name;
        this.lifeAmount = lifeAmount;
    }

    /**
     * Gets the name of the player.
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the life amount of the player.
     * @return The life amount of the player.
     */
    public int getLifeAmount() {
        return lifeAmount;
    }

    /**
     * Decrement one life.
     */
    public void decrementLife() {
        this.lifeAmount--;
    }

    /**
     * Checks if the player is still alive -> has some lives left.
     * @return The state of his lives.
     */
    public boolean isAlive() {
        return lifeAmount > 0;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Player: ")
                .append(name)
                .append("; Lives: ")
                .append(lifeAmount).toString();
    }
}
