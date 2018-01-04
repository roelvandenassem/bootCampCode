package exercises;

public class EnumExample {

    public enum BootCampDays {
        DAYONE,
        DAYTWO
    }

    public static String checkBootCampDaysInfo(BootCampDays bootCampDays){

        switch (bootCampDays){
            case DAYONE: default:
                return "Kerst was erg pittig";
            case DAYTWO:
                return "Hotelovernachting was ook erg pittig";
        }
    }
}
