import java.util.ArrayList;

public class Chapter_2 {
    /*
    第二章 观察者模式
    观察者模式分为两种对象，主题（subject)、观察者（observer)
    可用报纸的订阅比拟观察者模式，当报社出了新报时，会发给所有的观察者；随时会有新的对象订阅报纸，也会有旧对象取消订阅
    即，观察者模式创建了一种一对多依赖，当主题对象改变状态时，它的所有依赖者都会收到通知并自动更新
    本章代码是做一个气象站，当气象站数据变化时，通知显示面板改变显示数据，显示面板有多个且可以灵活扩充
    思路是把显示面板注册到气象站，当气象站数据变化时，通知注册过的面板改变信息
     */

    /*
    一条新的设计原则：
    为交互对象之间的松耦合设计而努力
     */

    public interface Observer{
        void update(float temperature, float humidity, float pressure);
    }

    public interface DisplayElement{
        void display();
    }

    public interface Subject{
        public void registerObserver(Observer o);
        public void deleteObserver(Observer o);
        public void notifyObservers();
    }

    public static class WeatherDate implements Subject{

        private ArrayList<Observer> observers;
        private float temperature;
        private float humidity;
        private float pressure;

        WeatherDate(){
            observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void deleteObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for(Observer observer : observers){
                observer.update(temperature, humidity, pressure);
            }
        }

        public void measurementsChanged(){
            notifyObservers();
        }

        public void setMeasurements(float temperature, float humidity, float pressure){
           this.temperature = temperature;
           this.humidity = humidity;
           this.pressure = pressure;
           measurementsChanged();
        }
    }

    public static class  CurrentConditionDisplay implements Observer, DisplayElement{

        private float temperature;
        private float humidity;
        private float pressure;
        private Subject weatherDate;

        CurrentConditionDisplay(Subject weatherDate){
            this.weatherDate = weatherDate;
            this.weatherDate.registerObserver(this);
        }

        @Override
        public void update(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;

            display();
        }

        public void display(){
            System.out.println("temperature: " + temperature + " humidity: " + humidity + " pressure: " + pressure);
        }
    }

    public static class WeatherStation{

        public static void main(String[] args) {
            WeatherDate weatherDate = new WeatherDate();
            CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherDate);
            // 更多显示面板略

            weatherDate.setMeasurements(100, 20, 30);
            weatherDate.setMeasurements(70, 25, 30);
        }
    }
}