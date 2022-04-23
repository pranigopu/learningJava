//IMPLEMENTATION OF ABSTRACT CLASS
/*
This program is a very simplistic way of interacting with digital creatures.
The main class, Mob, is supposed to be common to all these creatures.
But you should not instantiate it, since it is too generalised, and cannot offer creature action functionalities, which are unique to each creature.
This is a work in progress, so the action methods that are supposed to be unique ot each creature may be very similar for now.
However, uniqueness in the actions of the creatures in the goal.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.IOException;
abstract class Mob
{
    String name;
    int type, speed, attack, health, distance, attraction, repulsion;
    int repulsionFactor[] = new int[2];
    int attractionFactor;
    final String typeNames[] = new String[]{"Passive", "Hostile", "Neutral", "Playable"};
    int move()
    {
        if(this.distance - this.speed > 0)
        {
            this.distance = this.distance - this.speed;
            System.out.println("The " + this.name + " approaches you from " + this.distance + " steps away.");
            return 1;
        }
        this.distance = 0;
        return 0;
    }
    void info()
    {
        System.out.println("------------");
        System.out.println("MOB INFO");
        System.out.println("Name: " + this.name);
        System.out.println("Type: " + this.typeNames[this.type]);
        System.out.println("Speed: " + this.speed);
        System.out.println("Attack damage: " + this.attack);
        System.out.println("Health: " + this.health);
        System.out.println("------------");
    }
    void message(String str)
    {
        if(str == "attack")
            System.out.println("The " + this.name + " attacks!");
        else if(str == "watch")
            System.out.println("The " + this.name + " watches you from " + this.distance + " steps away.");
        else if(str == "flee")
            System.out.println("The " + this.name + " flees.");
        else if(str == "like")
            System.out.println("The " + this.name + " seems to like you!");
    }
    int takesDamageFrom(int attack)
    {
        if(attack > 0 && this.health - attack > 0)
        {
            this.health = this.health - attack;
            System.out.println("Health of " + this.name + " = " + this.health);
        }
        else if(this.health - attack <= 0)
        {
            System.out.println("The " + this.name + " is dead.");
            return -1;
        }
        return attack;
    }
    void getsAttracted(int intensity)
    {
        this.attraction = this.attraction + intensity;
    }
    void getsRepelled(int intensity)
    {
        this.repulsion = this.repulsion + intensity;
    }
    int acts()
    {
        if(this.attraction > this.repulsion)
        {
            if(move() == 0)
                return 1;
            else
                return -3;
        }
        else if(this.repulsion == this.attraction)
            return 0;
        return -1;
    }
    int reacts(int attack)
    {
        int tmp;
        tmp = takesDamageFrom(attack);
        if(tmp > 0)
            this.getsRepelled(repulsionFactor[0]);
        if(tmp == -1)
            return -1;
        else if(tmp == -2)
            this.getsRepelled(repulsionFactor[1]);
        else if(tmp == -3)
            this.getsAttracted(attractionFactor);
        else if(tmp == -4)
            this.info();
        return tmp;
    }
    Mob(String name, int type, int speed, int attack, int health, int attraction, int repulsion)
    {
        this.name = name;
        this.type = type;
        this.speed = speed;
        this.attack = attack;
        this.health = health;
        this.attraction = attraction;
        this.repulsion = repulsion;
    }
}
class Tiger extends Mob
{
    int myRepulsionFactor[] = new int[]{2, 2};
    Tiger()
    {
        super("tiger", 1, 8, 10, 20, 10, -10);
        this.repulsionFactor = this.myRepulsionFactor;
        this.attractionFactor = 0;
    }
    int action()
    {
        int tmp = acts();
        switch(tmp)
        {
            case 1:
                message("attack");
                System.out.println("GRRR!");
                return this.attack;
            case 2:
                return 0;
            case 0:
                message("watch");
                return 0;
            case -1:
                message("flees");
                return -1;
        }
        return tmp;
    }
    void getsRepelled(int intensity)
    {
        this.repulsion = this.repulsion + intensity;
    }
    int receives(int attack)
    {
        int tmp;
        tmp = reacts(attack);
        return tmp;
    }

}
class Deer extends Mob
{
    int myRepulsionFactor[] = new int[]{20, 10};
    Deer()
    {
        super("deer", 0, 15, 0, 10, 0, 0);
        this.repulsionFactor = this.myRepulsionFactor;
        this.attractionFactor = 1;
    }
    int action()
    {
        int tmp = acts();
        switch(tmp)
        {
            case 1:
                message("like");
                return 0;
            case 0:
                if(this.distance <= 0)
                    this.distance = this.distance + this.speed;
                message("watch");
                break;
            case -1:
                message("flee");
                break;
        }
        return tmp;
    }
    int receives(int attack)
    {
        int tmp;
        tmp = reacts(attack);
        return tmp;
    }
}
class Dog extends Mob
{
    int myRepulsionFactor[] = new int[]{8, 5};
    Dog()
    {
        super("dog", 2, 5, 5, 10, 10, 0);
        this.repulsionFactor = this.myRepulsionFactor;
        this.attractionFactor = 5;
    }
    int action()
    {
        int tmp = acts();
        switch(tmp)
        {
            case 1:
                if(this.type == 1)
                {
                    message("attack");
                    System.out.println("Grrrufff!");
                    return this.attack;
                }
                else
                {
                    message("like");
                    System.out.println("Bhow! Bhow!");
                    return 0;
                }
            case 0:
                if(this.distance <= 0)
                    this.distance = this.distance + this.speed;
                message("watch");
                break;
            case -1:
                message("flee");
                break;
        }
        return tmp;
    }
    int receives(int attack)
    {
        int tmp;
        tmp = reacts(attack);
        if(tmp > 0)
            this.type = 1;
        return tmp;
    }
}
class Player extends Mob
{
    int myRepulsionFactor[] = new int[]{0, 0};
    Player()
    {
        super("player", 3, 0, 5, 20, 0, 0);
        this.repulsionFactor = this.myRepulsionFactor;
        this.attractionFactor = 0;
    }
    int action() throws IOException
    {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Make your move...");
        System.out.println("1 to shoot an arrow");
        System.out.println("2 to scare");
        System.out.println("3 to go away");
        System.out.println("4 to offer food");
        System.out.println("Anything else to see info");
        c = (char)br.read();
        switch(c)
        {
            case '1':
                return this.attack;
            case '2':
                return -2;
            case '3':
                System.out.println("The player flees.");
                return -1;
            case '4':
                return -3;
        }
        return -4;
    }
    int receives(int attack)
    {
        int tmp;
        tmp = reacts(attack);
        return tmp;
    }
}
public class MeetTheMobs
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            Tiger tiger = new Tiger();
            Deer deer = new Deer();
            Dog dog = new Dog();
            Player player = new Player();
            char option;
            int distance, tmp;
            System.out.println();
            System.out.println("MEET THE MOBS");
            System.out.println("1 to meet the tiger");
            System.out.println("2 to meet the deer");
            System.out.println("3 to meet the dog");
            System.out.println("4 to see player info");
            System.out.println("x to exit");
            option = (char)br.read();
            br.read();
            if(option == 'x')
                break;
            else if(option < '1' || option > '4')
                continue;
            else if(option == '4')
            {
                player.info();
                continue;
            }
            System.out.println("Enter the initial distance between you and the mob.");
            distance = Integer.parseInt(br.readLine());
            System.out.println("========================");
            switch(option)
            {
                case '1':
                    System.out.println("Say hello to the tiger...");
                    System.out.println();
                    tiger.distance = distance;
                    while(true)
                    {
                        tmp = player.receives(tiger.action());
                        if(tmp == -1) break;
                        tmp = tiger.receives(player.action());
                        if(tmp == -1) break;
                    }
                    break;
                case '2':
                    System.out.println("Say hello to the deer...");
                    System.out.println();
                    deer.distance = distance;
                    while(true)
                    {
                        tmp = player.receives(deer.action());
                        if(tmp == -1) break;
                        tmp = deer.receives(player.action());
                        if(tmp == -1) break;
                    }
                    break;
                case '3':
                    System.out.println("Say hello to the dog...");
                    System.out.println();
                    dog.distance = distance;
                    while(true)
                    {
                        if(dog.type == 1)
                            System.out.println("The dog is hostile!");
                        tmp = player.receives(dog.action());
                        if(tmp == -1) break;
                        tmp = dog.receives(player.action());
                        if(tmp == -1) break;
                    }
                    break;
            }
            System.out.println("========================");
        }
        System.out.println();
        System.out.println("Goodbye!");
        System.out.println();
    }
}