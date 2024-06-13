package vip.yeee.zhongchou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vip.yeee.zhongchou.entity.InitiatorCompanyInfo;
import vip.yeee.zhongchou.entity.InitiatorPersonInfo;
import vip.yeee.zhongchou.entity.Project;
import vip.yeee.zhongchou.entity.ProjectRepay;
import vip.yeee.zhongchou.entity.ProjectCategory;
import vip.yeee.zhongchou.entity.ProjectDetail;
import vip.yeee.zhongchou.utils.JDBCUtils;
import vip.yeee.zhongchou.utils.Packager;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class ProjectDao extends BaseDao {

    private final ProjectCategoryDao projectCategoryDao = new ProjectCategoryDao();
    private final InitiatorInfoDao InitiatorInfoDao = new InitiatorInfoDao();

//获取基本显示首页信息

    public List<Project> getProjectByIs_index(int is, int type) throws SQLException {

        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;

        ResultSet rs = null;

        Project project = null;

        List<Project> p = new ArrayList<>();
        try {
            String sql = "SELECT * FROM project p WHERE p.is_index = " + is + " AND p.category_id = " + type;
            ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            while (rs.next()) {
                project = Packager.packProject(rs);
                p.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return p;

    }

    //通过project获取详情页面信息

    public Project getProjectById(int id) throws SQLException {
        String sql = "SELECT * FROM project WHERE project_id = " + id;
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet pd_rs = null;
        ResultSet pr_rs = null;

        Project project = null;
        InitiatorCompanyInfo initiatorC = null;
        InitiatorPersonInfo initiatorP = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {

                //封装保存project对象
                project = Packager.packProject(rs);

                if (project.getShenfen().equals("个人")) {
                    initiatorP = InitiatorInfoDao.getInitiatorPersonInfoByProject_id(project.getProject_id());
                    project.setInitiatorPersonInfo(initiatorP);
                } else if (project.getShenfen().equals("企业")) {

                    initiatorC = InitiatorInfoDao.getInitiatorCompanyInfoByProject_id(project.getProject_id());
                    project.setInitiatorCompanyInfo(initiatorC);
                }


                //封装保存projectdetail对象
                String pd_sql = "SELECT * FROM project_detail WHERE project_id = " + project.getProject_id();
                ps = con.prepareStatement(pd_sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pd_rs = ps.executeQuery();
                List<ProjectDetail> pdlist = new ArrayList<>();
                while (pd_rs.next()) {
                    ProjectDetail pd = Packager.packProjectdetail(pd_rs);
                    pdlist.add(pd);
                }
                project.setProjectdetail(pdlist);

                //封装保存projectrepay对象
                String pr_sql = "SELECT * FROM projectrepay WHERE project_id = " + project.getProject_id();
                ps = con.prepareStatement(pr_sql);
                pr_rs = ps.executeQuery();
                List<ProjectRepay> prlist = new ArrayList<>();
                while (pr_rs.next()) {
                    ProjectRepay pr = Packager.packProjectRepay(pr_rs);
                    prlist.add(pr);
                }
                project.setProjectRepay(prlist);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return project;
    }


    public Integer getProjectNum(String projectType, String key) throws SQLException {
        String sql = "SELECT count(*) FROM project WHERE 1=1  and is_audits=1 ";
        // TODO Auto-generated method stub
        if (key != null && !key.equals("")) {
            sql += "and  title LIKE '%" + key + "%'";
        }
        if (projectType != null) {
            if (!projectType.equals("") && !projectType.equals("-1")) {
                sql += " and category_id =" + projectType;
            }
            if (projectType.equals("-1")) {
                sql += "and category_id not in (1)";
            }
        }

        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        int count = 0;
        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count(*)");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }

        return count;
    }

    public List<Project> getProjectByCondition(Project project, Integer page, Integer showCount) throws SQLException {
        StringBuffer sql = new StringBuffer("SELECT * FROM project WHERE 1=1  ");
        if (project.getTitle() != null && !project.getTitle().equals("")) {
            sql.append(" and  title LIKE '%" + project.getTitle() + "%'");
        }
        if (project.getCategory_id() != 0) {
            if (project.getCategory_id() != -1) {
                sql.append(" and category_id =" + project.getCategory_id());
            }
            if (project.getCategory_id() == -1) {
                sql.append(" and category_id not in (1)");
            }
        }

        if (project.getUser_id() != 0) {
            sql.append(" and user_id=" + project.getUser_id());
        }

        if (project.getIs_audits() != null) {
            sql.append(" and is_audits =" + project.getIs_audits());
        }

        sql.append("  order by launch_date_raising desc");

        //int max = 20; //单页最大显示数
        int start = (page - 1) * showCount;

        Connection con = JDBCUtils.getConnection();
        List<Project> projects = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        Project p = null;

        try {
            ps = con.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setMaxRows(start + showCount);
            rs = ps.executeQuery();
            rs.first();
            rs.relative(start - 1);


            while (rs.next()) {
                p = Packager.packProject(rs);

                ProjectCategory projectCategory = projectCategoryDao.getCategoryById(p.getCategory_id());
                p.setProjectcategory(projectCategory);
                projects.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }

        return projects;

    }

    //获取全部  分页显示

    public List<Project> getProjectByPage(Integer page) {
        return null;
    }

    public void saveProject(Project project, List<ProjectDetail> projectdetails, List<ProjectRepay> projectRepays, Object identity) throws SQLException {
        Date current_date = new Date();//生成日期对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设置日期格式
        project.setLaunch_date(simpleDateFormat.format(current_date.getTime()));

        Connection conn = JDBCUtils.getConnection();

        String sql = "INSERT INTO project "
                + "(title,blurb,img_name,total_fund_raising,user_id,category_id,days_raising,is_audits,shenfen,launch_date_raising)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        String detail_sql = "INSERT INTO project_detail (project_id,dtitle,dcontent) VALUES(?,?,?)";
        String repay_sql = "INSERT INTO projectRepay (project_id,paytitle,paycontent,type,time,money) VALUES(?,?,?,?,?,?) ";

        Object[] param = {project.getTitle(),
                project.getBlurb(),
                project.getImg_name(),
                project.getTotal_fund_raising(),
                project.getUser_id(),
                project.getCategory_id(),
                project.getDays_raising(),
                project.getIs_audits(),
                project.getShenfen(),
                new Date()
        };

        try {
            JDBCUtils.beginTransaction();            //关闭事务自动提交，多表同时插入，需要保证都不出现异常才能提交事务

            /**
             * 首先保存基本信息表，返回id值
             */
            int project_id = save(sql, param, conn);            //保存基本信息操作，返回插入自增的id

            /**
             * 然后插入详情表
             */
            for (int i = 0; i < projectdetails.size(); i++) {
                Object[] param2 = {project_id, projectdetails.get(i).getTitle(), projectdetails.get(i).getContent()};

                saveOrUpdateOrDelete(detail_sql, param2);    //保存

            }

            /**
             * 紧接着建立项目回报信息
             */
            for (int i = 0; i < projectRepays.size(); i++) {

                Object[] param3 = {project_id, projectRepays.get(i).getTitle(),
                        projectRepays.get(i).getContent(),
                        projectRepays.get(i).getType(),
                        projectRepays.get(i).getTime(),
                        projectRepays.get(i).getMoney()};

                saveOrUpdateOrDelete(repay_sql, param3);            //保存
            }


            /**
             * 最后再把项目发布者身份信息也保存
             */
            if (identity instanceof InitiatorPersonInfo) {
                String pers_sql = "INSERT INTO Initiator_personInfo (project,name,IDnumber,phone,IDpicFace,IDpicInverse) VALUES(?,?,?,?,?,?)";
                Object[] param4 = {project_id,
                        ((InitiatorPersonInfo) identity).getName(),
                        ((InitiatorPersonInfo) identity).getIDnumber(),
                        ((InitiatorPersonInfo) identity).getPhone(),
                        ((InitiatorPersonInfo) identity).getSzimg(),
                        ((InitiatorPersonInfo) identity).getSfimg()
                };
                saveOrUpdateOrDelete(pers_sql, param4);
            } else {
                String comp_sql = "INSERT INTO Initiator_companyInfo (project,firmName,businessNumber,slanderName,address,contactName,contactPhone,licenesPic,registeredNumPic,taxPig) VALUES(?,?,?,?,?,?,?,?,?,?)";
                Object[] param5 = {project_id,
                        ((InitiatorCompanyInfo) identity).getFirmName(),
                        ((InitiatorCompanyInfo) identity).getBusinessNumber(),
                        ((InitiatorCompanyInfo) identity).getSlanderName(),
                        ((InitiatorCompanyInfo) identity).getAddress(),
                        ((InitiatorCompanyInfo) identity).getContactName(),
                        ((InitiatorCompanyInfo) identity).getContactPhone(),
                        ((InitiatorCompanyInfo) identity).getLicenesPic(),
                        ((InitiatorCompanyInfo) identity).getRegisteredNumPic(),
                        ((InitiatorCompanyInfo) identity).getTaxPig()
                };
                saveOrUpdateOrDelete(comp_sql, param5);
            }

            //最后的最后再去提交事务

            JDBCUtils.commitTransaction();


        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();

            try {
                JDBCUtils.rollbackTransaction();            //出现异常回滚
            } catch (SQLException e) {
                // TODO Auto-generated catch block

                e.printStackTrace();
                throw e;
            }
            throw e1;
        } finally {
            JDBCUtils.releaseConnection(conn);
        }

    }

    public Integer getProjectByUser_id(int user_id) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "SELECT count(*) FROM project WHERE user_id=" + user_id;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Integer count = 0;


        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return count;

    }

    public List<Project> getProjectByIs_audits(int is_audits) throws SQLException {
        String sql = "SELECT * FROM project WHERE is_audits=" + is_audits;
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Project> projects = new ArrayList<>();
        Project project = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                project = Packager.packProject(rs);
                ProjectCategory pc = projectCategoryDao.getCategoryById(project.getCategory_id());
                project.setProjectcategory(pc);
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return projects;
    }

    public void passAudits(int project_id, int is_audits) throws SQLException {
        // TODO Auto-generated method stub
        Connection con = JDBCUtils.getConnection();
        String sql = "UPDATE project SET is_audits=" + is_audits + " where project_id=" + project_id;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
    }

    public int updateProject(Project p) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        String sql = "UPDATE project SET has_fund_raising=" + p.getHas_fund_raising();
        sql += " where project_id = " + p.getProject_id();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(con);
        }
        return 0;
    }


}



