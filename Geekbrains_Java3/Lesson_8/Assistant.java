package Geekbrains_Java3.Lesson_8;

public class Assistant {
    public Camera getCamera() {
        Camera camera = new Camera();
        ICameraRoll cameraRoll = new ColorCameraRoll();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
