package pl.sda.parameter;

//TEST
public abstract class Parameter {
    public static final String ASSIGN = "=";
    String name;
    protected Parameter(String name) {
        this.name = name;
    }

    abstract public String valueAsString();
    public String asString(){
        return name +ASSIGN+ valueAsString();
    }
}
//http://www.omdbapi.com/?apikey=c26f0a5a&t=blade+runner