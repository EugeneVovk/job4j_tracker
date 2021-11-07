package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        HtmlReport report2 = new HtmlReport();
        JSONReport report3 = new JSONReport();
        String text = report.generate("Report's name", "Report's body");
        String html = report2.generate("Report's name", "Report's body");
        String json = report3.generate("name", "body");
        System.out.println(text);
        System.out.println(html);
        System.out.println(json);
    }
}
