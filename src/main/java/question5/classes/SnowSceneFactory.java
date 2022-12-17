package question5.classes;

public class SnowSceneFactory extends SceneFactory {
    @Override
    public Map createMap() {
        return new SnowMap();
    }

    @Override
    public Weather createWeather() {
        return new SnowWeather();
    }

    @Override
    public Sound createSound() {
        return new SnowSound();
    }
}