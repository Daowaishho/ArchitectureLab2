package question5.code;

import java.nio.file.Watchable;

public class Main {
    public static void main (String[] args) {
        try {
            Map AMap = SceneAFactory.createMap();
            Weather AWeather = SceneAFactory.createWeather();
            Sound ASound = SceneAFactory.createSound();

            Map BMap = SceneBFactory.createMap();
            Weather BWeather = SceneBFactory.createWeather();
            Sound BSound = SceneBFactory.createSound();

            AMap.display();
            AWeather.display();
            ASound.display();


            BMap.display();
            BWeather.display();
            BSound.display();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

abstract class SceneFactory {
    public static Map createMap() {
        return null;
    }

    public static Weather createWeather() {
        return null;
    }

    public static Sound createSound() {
        return null;
    }
}

class SceneAFactory extends SceneFactory{
    public static Map createMap() {
        return new AMap();
    }

    public static Weather createWeather() {
        return new AWeather();
    }

    public static Sound createSound() {
        return new ASound();
    }
}

class SceneBFactory extends SceneFactory{
    public static Map createMap() {
        return new BMap();
    }

    public static Weather createWeather() {
        return new BWeather();
    }

    public static Sound createSound() {
        return new BSound();
    }
}

abstract class Map {
    public void display() {

    }
}

class AMap extends Map{
    public void display() {
        System.out.println("显示场景A的Map");
    }
}

class BMap extends Map{
    public void display() {
        System.out.println("显示场景B的Map");
    }
}

abstract class Weather {
    public void display() {

    }
}

class AWeather extends Weather{
    public void display() {
        System.out.println("显示场景A的Weather");
    }
}

class BWeather extends Weather{
    public void display() {
        System.out.println("显示场景B的Weather");
    }
}

abstract class Sound {
    public void display() {

    }
}

class ASound extends Sound{
    public void display() {
        System.out.println("显示场景A的Sound");
    }
}

class BSound extends Sound{
    public void display() {
        System.out.println("显示场景B的Sound");
    }
}