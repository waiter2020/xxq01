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

    private DepartDaoImpl(){}


    @Override
    public Depart findByName(String departName){
        LinkedList listBySome = DBUtils.getListBySome(Depart.class, "departname", departName+"");
        if(listBySome.size()==0){
            return new Depart(0,"not exist");
        }else{
            return (Depart) listBySome.remove(0);
        }
    }

    @Override
    public boolean departInsert(Depart depart){
        return DBUtils.insert(depart);
    }

    @Override
    public boolean deleteByName(String departName){

        Depart depart=findByName(departName);
        if(depart.getDepartName()==null){
            return false;
        }else{
            return DBUtils.delete(Depart.class,depart.getId());
        }

    }


    @Override
    public PageBean listPage(PageBean pageBean) {
        return DBUtils.getPage(pageBean,Depart.class);
    }
    public static DepartDaoImpl getDepartDaoImpl() {
        return departDaoImpl;
    }
}
