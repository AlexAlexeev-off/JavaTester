package ru.alexxx.lesson1;

public class Wall extends Barrier {

    private int heigth;

    public Wall(String name, int heigth) {
        super(name);

        this.heigth = heigth;
    }

    public int getHeigth() {
        return heigth;
    }

    @Override
    protected boolean moving(Actions actions) {
        System.out.println("The " + super.getName() + " heigth: " + this.heigth);

        actions.jump();

        if (getHeigth() <= actions.getJumpHeight()) {
            System.out.println("jump \u001B[32m success \u001B[0m ");

            return true;
        } else {
            System.out.println("jump \u001B[31m unsuccessfully \u001B[0m ");

            return false;
        }
    }
}
