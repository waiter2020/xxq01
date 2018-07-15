package dao.impl;

import bean.Report;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午5:28 18-7-15
 */
public class ReportDaoImpl {
    private static final ReportDaoImpl reportDao = new ReportDaoImpl();
    private ReportDaoImpl(){}




    public synchronized static ReportDaoImpl getReportDao() {
        return reportDao;
    }
}
