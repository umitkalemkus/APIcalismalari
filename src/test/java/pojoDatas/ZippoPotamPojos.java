package pojoDatas;

public class ZippoPotamPojos {
   /* {
        "post code": "34010",
            "country": "Turkey",
            "country abbreviation": "TR",
            "places": [
        {
            "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
        }
    ]
    }

*/

    private  String postCode;
    private String  country;
    private String  countryAbbreviation;
    private  ZippoPotamPlaces zippoPotamPlaces;

    public ZippoPotamPojos() {


    }

    public ZippoPotamPojos(String postCode, String country, String countryAbbreviation, ZippoPotamPlaces zippoPotamPlaces) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.zippoPotamPlaces = zippoPotamPlaces;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public ZippoPotamPlaces getZippoPotamPlaces() {
        return zippoPotamPlaces;
    }

    public void setZippoPotamPlaces(ZippoPotamPlaces zippoPotamPlaces) {
        this.zippoPotamPlaces = zippoPotamPlaces;
    }

    @Override
    public String toString() {
        return "{" +
                "postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbreviation='" + countryAbbreviation + '\'' +
                ", zippoPotamPlaces=" + zippoPotamPlaces +
                '}';
    }
}
