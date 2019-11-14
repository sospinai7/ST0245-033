public class Dato {

    double ilum;
    double temp_env;
    double ph;
    double temp_soil;
    double moisture_soil;
    double hum_env;
    
    String marc;

    public Dato(double ph, double temp_soil, double moisture_soil, double ilum, double temp_env, double hum_env, String marc) {
        this.ph = ph;
        this.temp_soil = temp_soil;
        this.moisture_soil = moisture_soil;
        this.ilum = ilum;
        this.temp_env = temp_env;
        this.hum_env = hum_env;
        this.marc = marc;
    }
    public double getPh() {
        return ph;
    }
    public double gettemp_soil() {
        return temp_soil;
    }
    public double getmoisture_soil() {
        return moisture_soil;
    }
    public double getilum() {
        return ilum;
    }
    public double gettemp_env() {
        return temp_env;
    }
    public double gethum_env() {
        return hum_env;
    }
    public String getmarc() {
        return marc;
    }


    public double getValue(int i) throws Exception {
        switch (i) {
            case 0:
                return getPh();
            case 1:
                return gettemp_soil();
            case 2:
                return getmoisture_soil();
            case 3:
                return getilum();
            case 4:
                return gettemp_env();
            case 5:
                return gethum_env();
            default:
                throw new Exception("No existe el tipo de dato mencionado");
        }
    }
}
