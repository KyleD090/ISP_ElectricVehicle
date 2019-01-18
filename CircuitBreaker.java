public class CircuitBreaker {
    boolean breaker;
    double temp;
    Battery b;
    CircuitBreaker(Battery b){
        this.b = b;
        breaker = false;
    }

    void pullBreaker(){
        breaker = true;
        temp = b.elapsedTime;
        b.elapsedTime = b.time++;
    }

    void resetBreaker(){
        breaker = false;
        b.elapsedTime = temp;
    }
}
