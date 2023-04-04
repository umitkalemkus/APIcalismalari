package BaseURLs;

public class MemberShipPojo {



    private String name;
    private String is_enabled;


    public MemberShipPojo() {
    }

    public MemberShipPojo(String name, String is_enabled) {
        this.name = name;
        this.is_enabled = is_enabled;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(String is_enabled) {
        this.is_enabled = is_enabled;
    }




}
