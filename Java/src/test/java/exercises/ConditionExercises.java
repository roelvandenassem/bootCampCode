package exercises;

import org.testng.annotations.Test;

public class ConditionExercises {

    int minAge = 21;
    int maxAge = 65;

    @Test
    public void main(){
        System.out.println(bootcampAgeChecker(12));
        System.out.println(bootcampAgeChecker(21));
        System.out.println(bootcampAgeChecker(64));
        System.out.println(bootcampAgeChecker(65));
    }

    public String bootcampAgeChecker(int age) {
        int minAge = 21;
        int maxAge = 65;

        if (age < minAge) {
            return age + ": deelnemer is te jong";
        } else if (age >= maxAge) {
            return age + ": Deelnemer niet toegelaten, check bij de manager.";
        } else {
            return age + " deelnemer toegelaten";
        }
    }

//    public String bootcampAgeChecker(int age,int minAge) {
//
//            if (age < minAge) {
//                return "deelnemer is te jong";
//            } else {
//                return "deelnemer toegelaten";
//            }
//        }
}
