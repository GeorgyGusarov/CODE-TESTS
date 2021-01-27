package Geekbrains_Java3.Lesson_7.HomeworkCheck;

@XTable(name = "students")
public class Students {
    @XField
    int id;

    @XField
    String name;

    @XField
    int score;

    @XField
    String email;

    public Students(int id, String name, int score, String email) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.email = email;
    }
}
