package question11.code;

public class Main {
    public static void main(String[] args) {
        StatisticalAnalysis statisticalAnalysis = new ExamineeScoreAnalysis();
        DataExporter dataExporter = new ExcelExporter();
        statisticalAnalysis.setDateExporter(dataExporter);
        statisticalAnalysis.analysis();
        statisticalAnalysis.export();
    }
}

abstract class StatisticalAnalysis {
    protected String statistics = "空数据";
    protected DataExporter dataExporter;
    public void setDateExporter(DataExporter dataExporter) {
        this.dataExporter = dataExporter;
    }
    public abstract void analysis();
    public void export() {
        dataExporter.exportData(this.statistics);
    }
}

class ScoreDistributionAnalysis extends StatisticalAnalysis{
    public void analysis() {
        this.statistics = "模拟的分数分布数据";
    }
}

class QuestionCorrectRateAnalysis extends StatisticalAnalysis{
    public void analysis() {
        this.statistics = "模拟的题目正确率数据";
    }
}

class ExamineeScoreAnalysis extends StatisticalAnalysis{
    public void analysis() {
        this.statistics = "模拟的考生得分情况数据";
    }
}

interface DataExporter {
    void exportData(String data);
}

class ExcelExporter implements DataExporter{
    public void exportData(String data) {
        System.out.println("将"+data+"用Excel导出");
    }
}

class WordExporter implements DataExporter{
    public void exportData(String data) {
        System.out.println("将"+data+"用Word导出");
    }
}

class ImageExporter implements DataExporter{
    public void exportData(String data) {
        System.out.println("将"+data+"用Image导出");
    }
}
