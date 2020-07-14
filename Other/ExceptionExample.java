package Other;

import java.io.IOException;

public class ExceptionExample {
    boolean abandonAllHope = true;

    public void takeRisk() throws Exception, IOException {
        if (abandonAllHope) {
            throw new Exception();
        }
    }

    public void takeRiskAgain() throws Exception, IOException {
        if (abandonAllHope) {
            throw new IOException();
        }
    }

    public static void main(String[] args) {
        ExceptionExample exceptionExample = new ExceptionExample();

            try {
                exceptionExample.takeRisk();
                exceptionExample.takeRiskAgain(); // не сработает, так как ошибка будет раньше
            } catch (IOException io) {
                System.out.println("Код в этом блоке выполнится, если будет IOException");
                io.printStackTrace();
            } catch (Exception e) {
                System.out.println("Код в этом блоке выполнится, если будет Exception");
                e.printStackTrace();
            } finally {
                System.out.println("Выполнится в любом случае!");
            }
    }

}
