package Other;

public class Doctor {
    boolean worksAtHospital;

    void treatPatient(){
        System.out.println("Проводим проверку");
    }
}

class FamilyDoctor extends Doctor {
    boolean makesHouseCalls;

    void giveAdvice() {
        System.out.println("Даем простой совет");
    }
}

class Surgeon extends Doctor {

    void treatPatient() {
        System.out.println("Проводми опреацию");
    }

    void makeIncision() {
        System.out.println("Делаем надрез");
    }
}

class DoctorTestDrive {
    public static void main(String[] args) {
        Doctor doc = new Doctor();
        doc.treatPatient();
    }
}