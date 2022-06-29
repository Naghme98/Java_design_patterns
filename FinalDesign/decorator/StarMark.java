package decorator;

public class StarMark extends ReportDecorators{
    public StarMark(Report report){
        super(report);
    }
    public String showText(){
        return decorateWithStarMark()+super.showText();
    }
    private String decorateWithStarMark(){
        return "* ";
    }
    
}