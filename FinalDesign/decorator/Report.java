package decorator;

public  interface Report {
    public  String showText();
    public  Report removeDecorate(String className);
    public  Report undecorate();
}