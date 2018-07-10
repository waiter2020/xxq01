package dao.impl;

import bean.Depart;
import dao.DepartDao;
import utils.DBUtils;
import utils.PageBean;

import java.util.LinkedList;


/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:50 18-7-9
 * 部门Dao层接口实现类
 */
public class DepartDaoImpl implements DepartDao{
    private static final DepartDaoImpl departDaoImpl = new DepartDaoImpl();

    DepartDaoImpl(){}

    public LinkedList departList(){
        LinkedList list = null;
        list = DBUtils.getList(Depart.class);
        if(list==null){
            return null;
        }else{
            return list;
        }
    }
    public Depart findById(String staffid){
        LinkedList departName = DBUtils.getListBySome(Depart.class, "staffid", staffid);
        Depart depart = (Depart) departName.remove(0);
        if(depart==null){
            return null;
        }else{
            return depart;
        }
    }
    public Depart findByName(String departname){
        LinkedList departName = DBUtils.getListBySome(Depart.class,"departname",departname);
        Depart depart = (Depart) departName.remove(0);
        if(depart==null){
            return null;
        }else{
            return depart;
        }
    }
    public boolean departInsert(Depart depart){
        return DBUtils.insert(depart);
    }
    public boolean DeleteByName(String departname){
        Depart depart=findByName(departname);
        DBUtils.delete(Depart.class,depart.getId());
        return true;
    }
    public boolean updateByName(Depart depart){
        return DBUtils.update(depart);
    }

    public PageBean listPage(PageBean pageBean) {
        return DBUtils.getPage(pageBean,Depart.class);
    }
    public static DepartDaoImpl getDepartDaoImpl() {
        return departDaoImpl;
    }
}
