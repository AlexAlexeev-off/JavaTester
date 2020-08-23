package ru.alexxx.lesson1;

public class Road extends Barrier {
    private int length;

    public Road(String name, int length) {
        super(name);

        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    protected boolean moving(Actions actions) {
        System.out.println("The " + super.getName() + " length: " + this.length);

        actions.run();

        if (getLength() <= actions.getRunDistance()) {
            System.out.println("run \u001B[32m success \u001B[0m ");

            return true;
        } else {
            System.out.println("run \u001B[31m unsuccessfully \u001B[0m ");

            return false;
        }
    }
}