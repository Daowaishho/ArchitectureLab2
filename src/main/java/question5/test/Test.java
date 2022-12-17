package question5.test;

import question5.classes.*;

public class Test {
    public static void main(String []args){
        // 创建 SnowSceneFactory 对象
        SceneFactory factory = new SnowSceneFactory();

// 创建雪地场景中的地图、天气和背景音乐
        Map map = factory.createMap();
        Weather weather = factory.createWeather();
        Sound sound = factory.createSound();

// 显示地图、天气和播放背景音乐
        map.show();
        weather.display();
        sound.play();

    }
}
