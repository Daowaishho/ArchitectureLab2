package question5.classes;

public abstract class SceneFactory {
    public abstract Map createMap();
    public abstract Weather createWeather();
    public abstract Sound createSound();
}