package Other;

public class ElectricGuitar {
    String brand;
    int numOfPickups;
    boolean rockStarUsesIt;

    String getBrand() {
        return brand;
    }
    void setBrand(String aBrand) { // принимает параметр aBrand
        brand = aBrand;
    }

    int getNumOfPickups() {
        return numOfPickups;
    }
    void setNumOfPickups(int num) { // принимает параметр num
        numOfPickups = num;
    }

    boolean getRockStarUsesIt() {
        return rockStarUsesIt;
    }
    void setRockStarUsesIt(boolean yesOrNo) { // принимает параметр yesOrNo
        rockStarUsesIt = yesOrNo;
    }
}
