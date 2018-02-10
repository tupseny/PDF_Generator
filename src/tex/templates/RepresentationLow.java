package tex.templates;

import java.io.File;
import java.util.Calendar;

public class RepresentationLow extends Template{
    /**
     * Changes columns width
     *
     * @param c - float array that contains all column sizes. (length = 8)
     */
    public void setColumnSize(float[] c) {
        this.c1 = c[0];
        this.c2 = c[1];
        this.c3 = c[2];
        this.c4 = c[3];
        this.c5 = c[4];
        this.c6 = c[5];
        this.c7 = c[6];
        this.c8 = c[7];
    }

    /**
     * Changes titles
     *
     * @param t - String array that contains new titles. (length = 4)
     */
    public void setTitles(String[] t) {
        this.title1 = t[0];
        this.title2 = t[1];
        this.title3 = t[2];
        this.title4 = t[3];
    }

    //default values
    private float c1 = 0.015f;
    private float c2 = 0.13f;
    private float c3 = 0.08f;
    private float c4 = 0.075f;
    private float c5 = 0.07f;
    private float c6 = 0.24f;
    private float c7 = 0.08f;
    private float c8 = 0.1f;
    private String title1 = "ПРЕДСТАВЛЕНИЕ";
    private String title2 = "на присвоение (подтверждение),юношеских спортивных разрядов, I спортивного разряда, II спортивного разряда, III спортивного разряда";
    private String title3 = "Региональная спортивная федерация спортивного туризма,Санкт-Петербурга";
    private String title4 = "Спортивный туризм";

    /**
     * Changes!
     *
     * @param organisationMaster - Name of the man who signs the document
     */
    public void setOrganisationMaster(String organisationMaster) {
        this.organisationMaster = organisationMaster;
    }

    /**
     * Changes!
     *
     * @param organisationName - Name of the organisation
     */
    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    /**
     * Changes!
     *
     * @param year - when the document is signed
     */
    public void setYear(String year) {
        this.year = year;
    }

    private String organisationMaster = "Здесь будет важдный чувак";
    private String organisationName = "ССК <<Кронверские барсы>>";
    private String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

    //custom values
    private String no;
    private String playerName;
    private String birthDate;
    private String rangName;
    private String rangDate;
    private String competitionName;
    private String result;
    private String teacherName;


    /**
     * Set values to be added to the file
     *
     * @param file - TeX File
     * @param no - Value to be added to the document
     * @param playerName - Value to be added to the document
     * @param birthDate - Value to be added to the document
     * @param rangName - Value to be added to the document
     * @param rangDate - Value to be added to the document
     * @param competitionName - Value to be added to the document
     * @param result - Value to be added to the document
     * @param teacherName - Value to be added to the document
     */
    public RepresentationLow(File file, String no, String playerName, String birthDate, String rangName, String rangDate, String competitionName,
                             String result, String teacherName){
        super(file);
        this.no = no;
        this.playerName = playerName;
        this.birthDate = birthDate;
        this.rangName = rangName;
        this.rangDate = rangDate;
        this.competitionName = competitionName;
        this.result = result;
        this.teacherName = teacherName;
    }

    /**
     * @param file - TeX file
     * @param vals - String array that contains all values. (length = 8)
     */
    public RepresentationLow(File file, String[] vals){
        this(file, vals[0], vals[1], vals[2], vals[3], vals[4], vals[5], vals[6], vals[7]);
    }

    /**
     * Generates TeX file including added in constructor values
     *
     * @return - If TeX file creating succeeded
     */
    public boolean generate(){
        System.out.println("%-- TEX generating --%");
        t.append("\\documentclass[a4paper, landscape]{article}\n" +
                "\\usepackage[utf8]{inputenc}\n" +
                "\\usepackage[russian]{babel}\n" +
                "\\usepackage[a4paper,landscape]{geometry}\n" +
                "\\usepackage[normalem]{ulem}\n" +
                "\\usepackage{calc}\n" +
                "\\usepackage{array}\n" +
                "\\usepackage{multirow}\n" +
                "\\usepackage{longtable}\n" +
                "\\newcolumntype{L}[1]{>{\\raggedright\\let\\newline\\\\\\arraybackslash\\hspace{0pt}}m{#1}}\n" +
                "\\newcolumntype{C}[1]{>{\\centering\\let\\newline\\\\\\arraybackslash\\hspace{0pt}}m{#1}}\n" +
                "\\newcolumntype{R}[1]{>{\\raggedleft\\let\\newline\\\\\\arraybackslash\\hspace{0pt}}m{#1}}\n" +
                "\\useunder{\\uline}{\\ul}{}\n" +
                "\\textwidth = 800pt\n" +
                "\\hoffset = -105pt\n" +
                "\\thispagestyle{empty}\n");
        t.append("\\begin{document}\n");
        t.append("\\centering\\section*{\\textbf{").append(title1).append("}\\\\}\n");
        t.append("\\renewcommand{\\arraystretch}{1.5}\n" +
                "\\begin{table}[h]\n" +
                "\\centering\n" +
                "\\begin{tabular}{ll}\n");
        t.append("\\multicolumn{2}{c}{").append(title2).append("}\\\\\n");
        t.append("\\cline{1-2}\n");
        t.append("& {").append(title3).append("}\\\\\n");
        t.append("\\cline{2-2}\n");
        t.append("{по виду спорта} & {").append(title4).append("}\\\\\n");
        t.append("\\cline{2-2}\n" +
                "\\end{tabular}\n" +
                "\\end{table}\n" +
                "\\centering\n");
        t.append("\\begin{longtable}{|C{")
                .append(c1).append("\\textwidth}|C{")
                .append(c2).append("\\textwidth}|C{")
                .append(c3).append("\\textwidth}|C{")
                .append(c4).append("\\textwidth}|C{")
                .append(c5).append("\\textwidth}|C{")
                .append(c6).append("\\textwidth}|C{")
                .append(c7).append("\\textwidth}|C{")
                .append(c8).append("\\textwidth}|}\n");
        t.append("\\hline\n");
        t.append("{№}&{Ф.И.О.}&{Дата\\newlineрождения}&{Наличие\\newlineспортивного\\newlineразряда}" +
                "&{Дата\\newlineвыполнения\\newlineразряда}&{Наименование соревнований, место и сроки проведения}" +
                "&{Показанный\\newlineрезультат}&{Ф.И.О. тренера-преподавателя}\\\\\\hline\n");
        t.append("{")
                .append(no).append("}&{")
                .append(playerName).append("}&{")
                .append(birthDate).append("}&{")
                .append(rangName).append("}&{")
                .append(rangDate).append("}&\\multirow{2}{0.24\\textwidth}{")
                .append(competitionName).append("}&{")
                .append(result).append("}&{")
                .append(teacherName).append("}\\\\[5em]\\cline{1-5}\\cline{7-8}\n");
        t.append("\\hline\n" +
                "\\endfoot\n" +
                "\\end{longtable}\n" +
                "\n" +
                "\\renewcommand{\\arraystretch}{1}\n" +
                "\\begin{flushleft}\n" +
                "\\begin{table}[!htbp]\n" +
                "\\hspace{0.08\\textwidth}\n" +
                "\\begin{tabular}{L{0.23\\textwidth}C{0.13\\textwidth}C{0.3\\textwidth}}\n");
        t.append("{").append(organisationMaster).append("}&\\rule{2cm}{0.5pt}&\\rule{4cm}{0.5pt}\\\\\n");
        t.append("&{подпись}&{Ф.И.О.}\\\\\n");
        t.append("{").append(organisationName).append("}&\\rule{0pt}{20pt}{\\rule{2cm}{0.5pt}}" +
                "&\\rule{0pt}{20pt}{\\rule{4cm}{0.5pt}}\\\\\n");
        t.append("&{подпись}&{Ф.И.О.}\\\\\n");
        t.append("\\rule{0pt}{24pt}&&\\\\\n");
        t.append("<<\\rule{0.7cm}{0.5pt}>> \\rule{2.5cm}{0.5pt} ").append(year).append(" год&&\n");
        t.append("\\end{tabular}\n" +
                "\\end{table}\n" +
                "\\end{flushleft}\n" +
                "\\end{document}\n");

        return true;
    }
}
