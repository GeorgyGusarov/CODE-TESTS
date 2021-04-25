package Geekbrains_Java3.Lesson_8;

public class Camera {
    private ICameraRoll cameraRoll;

    public void setCameraRoll(ICameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void doPhotograph() {
        System.out.println("Щелк!");
        cameraRoll.takeAPhoto();
    }
}


