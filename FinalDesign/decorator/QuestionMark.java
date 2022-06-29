package decorator;

public class QuestionMark extends ReportDecorators {
    public QuestionMark(){}
    public QuestionMark(Report report){
        super(report);
    }
    public String showText(){
        return decorateWithQuestionMark()+super.showText();
    }
    private String decorateWithQuestionMark(){
        return "? ";
    }


}