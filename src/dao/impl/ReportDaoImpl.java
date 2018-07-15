package dao.impl;

import bean.Depart;
import bean.Report;
import utils.BeanUtils;
import utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午5:28 18-7-15
 */
public class ReportDaoImpl {
    private static final ReportDaoImpl reportDao = new ReportDaoImpl();
    private ReportDaoImpl(){}


    /**
     * 绩效
     * @param start
     * @param end
     * @return
     */
    public  LinkedList getReport1(String start, String end){
        LinkedList<Report> list= new LinkedList<>();
        String sql="SELECT avg(score) as avgScore,Staff.department as departId,avg(present) as avgPresent\n" +
                "from Performance,Staff\n" +
                "where mouth > \""+start+"\" AND mouth < \""+end+"\" AND Performance.staff=Staff.id\n" +
                "GROUP BY Staff.department;\n";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                double aDouble = set.getDouble(1);
                int anInt = set.getInt(2);
                double aDouble1 = set.getDouble(3);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);

                report.setAvgScore(aDouble);
                report.setAvgPresent(aDouble1);
                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    /**
     * 在职
     * @param start
     * @param end
     * @return
     */
    public  LinkedList getReport2(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT COUNT(*) as zNum,Staff.department AS departId\n" +
                "from Office,Staff\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state<>2\n" +
                "Group By Staff.department;\n";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                int aDouble = set.getInt(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setzNum(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    /**
     * 离职
     * @param start
     * @param end
     * @return
     */
    public  LinkedList getReport3(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT COUNT(*),Staff.department\n" +
                "from Office,Staff\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state=2\n" +
                "Group By Staff.department;";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                int aDouble = set.getInt(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setlNum(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    /**
     * 实习
     * @param start
     * @param end
     * @return
     */
    public  LinkedList getReport4(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT COUNT(*),Staff.department\n" +
                "from Office,Staff\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state=0\n" +
                "Group By Staff.department;";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                int aDouble = set.getInt(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setsNum(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    /**
     * 在职
     * @param start
     * @param end
     * @return
     */
    public  LinkedList getReport5(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT COUNT(*),Staff.department\n" +
                "from Office,Staff\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state=1\n" +
                "Group By Staff.department;";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                int aDouble = set.getInt(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setyNum(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    /**
     * 离职
     * @param start
     * @param end
     * @return
     */
    public  LinkedList getReport6(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT COUNT(*),Staff.department\n" +
                "from Office,Staff\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state=2\n" +
                "Group By Staff.department;";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                int aDouble = set.getInt(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setlNum(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    /**
     * 平均年龄
     * @param start
     * @param end
     * @return
     */
    public  LinkedList getReport7(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT AVG(age),Staff.department\n" +
                "from Office,Staff\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state<>2\n" +
                "Group By Staff.department;";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                double aDouble = set.getDouble(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setAvgAge(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    /**
     * 男
     * @param start
     * @param end
     * @return
     */
    public  LinkedList getReport8(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT COUNT(*),Staff.department\n" +
                "from Office,Staff\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state<>2 and Staff.sex=0\n" +
                "group by Staff.department;\n";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                int aDouble = set.getInt(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setMan(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }


    public  LinkedList getReport9(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT COUNT(*),Staff.department\n" +
                "from Office,Staff\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state<>2 and Staff.sex=1\n" +
                "group by Staff.department;\n";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                int aDouble = set.getInt(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setWoman(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    public  LinkedList getReport10(String start, String end){
        LinkedList<Report> list=new LinkedList<>();
        String sql="SELECT COUNT(*),Staff.department,AVG(Staff.age)\n" +
                "from Staff,Office\n" +
                "where `date`>\""+start+"\" AND `date` < \""+end+"\" AND Office.staff=Staff.id and state<>2\n" +
                "group by Staff.department;\n";
        ResultSet set = DBUtils.executeQuerySQL(sql);
        try {
            while (set.next()){
                int aDouble = set.getInt(1);
                int anInt = set.getInt(2);
                Report report = new Report();
                Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, anInt);
                report.setDepartName(objectById.getDepartName());
                report.setDepartId(anInt);
                report.setWoman(aDouble);

                list.add(report);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    public synchronized static ReportDaoImpl getReportDao() {
        return reportDao;
    }
}
