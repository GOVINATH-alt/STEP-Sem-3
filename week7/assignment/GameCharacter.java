public class GameCharacter {
    private final String name;
    private final int maxHealth;
    private int currentHealth;

    public GameCharacter(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = Math.max(1, maxHealth);
        this.currentHealth = this.maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) return;
        currentHealth = Math.max(0, currentHealth - amount);
        System.out.printf("%s took %d damage -> Health: %d/%d%n", name, amount, currentHealth, maxHealth);
    }

    public void heal(int amount) {
        if (amount <= 0) return;
        currentHealth = Math.min(maxHealth, currentHealth + amount);
        System.out.printf("%s healed %d -> Health: %d/%d%n", name, amount, currentHealth, maxHealth);
    }

    public int getHealth() {
        return currentHealth;
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 1: The Health Bar ===");
        GameCharacter hero = new GameCharacter("Warrior", 100);
        hero.takeDamage(40);
        hero.takeDamage(80); // Capped at 0
        hero.heal(50);
        hero.heal(200); // Capped at 100
    }
}
