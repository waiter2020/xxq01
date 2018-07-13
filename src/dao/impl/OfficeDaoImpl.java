package dao.impl;

import bean.Office;
import dao.OfficeDao;
import utils.DBUtils;
import utils.PageBean;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午4:25 18-7-11
 */
public class OfficeDaoImpl implements OfficeDao{
    public OfficeDaoImpl(){}
    private final static OfficeDaoImpl officeDaoImpl = new OfficeDaoImpl();

    @Override
    public PageBean findByDate(PageBean pageBean,Class cls,String name1,String value1,String name2,String value2){
        pageBean = DBUtils.getPageByBeforSomeAndAfterSome(pageBean,cls,name1,value1,name2,value2);
        return pageBean;
    }

    @Override
    public boolean save(Office office) {
        return DBUtils.insert(office);
    }


    public static OfficeDaoImpl getOfficeDaoImpl(){
        return officeDaoImpl;
    }
}
