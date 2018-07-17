package service;

import bean.Depart;
import dao.DepartDao;
import dao.impl.DepartDaoImpl;
import utils.PageBean;

import java.util.LinkedList;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午4:28 18-7-10
 */
public class DepartService {
    private final DepartDao departDao = DepartDaoImpl.getDepartDaoImpl();
    private static final DepartService departService = new DepartService();

    private DepartService() {
    }


    /**
     * 通过部门名称查询部门信息
     *
     * @param departname
     * @return 部门实体类，包含所查找元组
     */
    public Depart findByName(String departname) {
        return departDao.findByName(departname);
    }

    /**
     * 向部门信息表插入一条新的数据
     *
     * @param depart
     * @return 是否成功执行插入操作
     */
    public boolean departInsert(Depart depart) {
        return departDao.departInsert(depart);
    }

    /**
     * 通过部门名删除一条信息
     *
     * @param departname
     * @return 是否成功删除成功
     */
    public boolean deleteByName(String departname) {
        return departDao.deleteByName(departname);
    }


    /**
     * 分页展示部门信息
     *
     * @param
     * @return PageBean
     */
    public PageBean listPage(PageBean pageBean) {
        return departDao.listPage(pageBean);
    }

    /**
     * 添加一个部门
     *
     * @param depart
     * @return
     */
    public boolean addDepart(Depart depart) {
        return departDao.departInsert(depart);
    }

    /**
     * 通过id查找部门
     *
     * @param id
     * @return
     */
    public Depart findById(int id) {
        return departDao.findById(id);
    }

    /**
     * 查询所有部门
     *
     * @return
     */
    public LinkedList<Depart> findAll() {
        return departDao.findAll();
    }


    public static DepartService getDepartService() {
        return departService;
    }


}
