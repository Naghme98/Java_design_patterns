package decorator;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public abstract class ReportDecorators implements Report {
    private Report report;
    public ReportDecorators(){}
    public ReportDecorators(final Report report) {
        this.report = report;
    }

    @Override
    public String showText() {
        return report.showText();
    }

    @Override
    public Report undecorate() {
        return this.report;
    }

    public Report removeDecorate(final String className) {
        Report undecorate = this;
        if (undecorate.getClass().getName().equals(className)) {
            undecorate = this.undecorate();
        } else {
            final ArrayList<String> classBack = new ArrayList<>();
            while (undecorate != undecorate.undecorate()) {
                if (undecorate.getClass().getName() != className) {
                    final String toAdd = undecorate.getClass().getName();
                    classBack.add(toAdd);
                }
                undecorate = undecorate.undecorate();
            }
            for (int i = classBack.size() - 1; i >= 0; i--) {
                try {
                    final Class<?> clazz = Class.forName(classBack.get(i));
                    final Constructor<?> ctor = clazz.getConstructor(Report.class);
                    final Object object = ctor.newInstance(new Object[] { undecorate });
                    undecorate = (Report) object;
                } catch (final Exception e) {
                    System.out.println("Exception:" + e.getMessage());
                }
            }

        }
        return undecorate;
        
    }


}