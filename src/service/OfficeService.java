package service;

import bean.Office;
import dao.OfficeDao;
import dao.impl.OfficeDaoImpl;
import utils.PageBean;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午8:43 18-7-11
 */
public class OfficeService {
    private final OfficeDao officeDao = OfficeDaoImpl.getOfficeDaoImpl();
    private static final OfficeService officeService=new OfficeService();
    private OfficeService(){}

    /**
     * 分页查询符合日期范围的报表
     * @param pageBean
     * @param cls
     * @param name1
     * @param value1
     * @param name2
     * @param value2
     * @return 符合日期范围的信息
     */
    PageBean findByDate(PageBean pageBean, Class cls, String name1, String value1, String name2, String value2){
        return officeDao.findByDate(pageBean,cls,name1,value1,name2,value2);
    }

    public static OfficeService getOfficeService(){
        return officeService;
    }
}
