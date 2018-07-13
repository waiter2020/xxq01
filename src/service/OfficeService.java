package service;

import bean.Office;
import bean.Staff;
import dao.OfficeDao;
import dao.impl.OfficeDaoImpl;
import utils.PageBean;

import java.util.Date;

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

    /**
     * 保存一条记录
     * @param staff
     * @param state
     * @return
     */
    public boolean save(Staff staff,int state){
        return officeDao.save(new Office(staff,new Date(),state));
    }

    public Office findLastByStaff(int staff){
        return officeDao.findLastByStaff(staff);
    }


    public static OfficeService getOfficeService(){
        return officeService;
    }
}
