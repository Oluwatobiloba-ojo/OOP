package fan;

public enum Speed {
    SLOW(1), MEDIUM(2), MAXIMUM(3);

   public int valueSpeed;

    Speed(int value){
        this.valueSpeed = value;
    }
}
