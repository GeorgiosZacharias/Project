package OS;

public class OSFactory {


    public static OS.OperatingSystem getOS(String OSType){
        if(OSType == null){
            return null;
        }
        if(OSType.equalsIgnoreCase("Windows")){
            return new Windows();

        } else if(OSType.equalsIgnoreCase("Linux")){
            return new OS.Linux();

        } else if(OSType.equalsIgnoreCase("macOS")){
            return new macOS();
        }

        return null;
    }
}