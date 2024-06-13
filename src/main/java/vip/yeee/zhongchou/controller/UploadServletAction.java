package vip.yeee.zhongchou.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vip.yeee.zhongchou.constant.Constants;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 当前为jdbc+servlet+jsp版本
 * 前后端分离版：https://gitee.com/yeeevip/yeee-crowdfunding
 *
 * @author https://www.yeee.vip
 */
public class UploadServletAction extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        String action = path.substring(path.lastIndexOf("/"));

        String filePath = req.getServletContext().getRealPath("");//绝对路径


        if (action.equals("/upload_cover.jhtml")) {
            /**
             * 封面图片上传
             */

            String newFolder = "/img/project/shoutu/";    //保存在服务器下的新文件夹，没有则创建
            String preFilename = (String) req.getSession().getAttribute(Constants.FILE_NAME);
            File preFile = new File(filePath + newFolder + preFilename);
            if (preFile.exists()) {
                preFile.delete();//删除前一次上传的封面
            }
            String filename = uploadPic(req, newFolder);
            resp.getWriter().print(req.getContextPath() + newFolder + filename);//返回生成的文件名及后缀
        }

        if (action.equals("/upload_detail.jhtml")) {
            /**
             * 详情页图片上传
             */
            String newFolder = "/img/project/detail/";    //保存在服务器下的新文件夹，没有则创建
            String fileName = uploadPic(req, newFolder);//保存并得到新文件名
            resp.getWriter().print(req.getContextPath() + newFolder + fileName);//文件路径返回前台

        }
        if (action.equals("/upload_IDphoto.jhtml")) {
            //身份证照片上传
            String newFolder = "/img/project/IDphoto/";    //保存在服务器下的新文件夹，没有则创建
            String fileName = uploadPic(req, newFolder);//保存并得到新文件名
            resp.getWriter().print(req.getContextPath() + newFolder + fileName);//文件路径返回前台
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    /**
     * 文件上传的方法
     *
     * @param request
     * @param folder  上传的文件夹
     * @return 文件名+后缀
     * @throws IOException
     * @throws ServletException
     */

    private String uploadPic(HttpServletRequest request, String folder) throws IOException, ServletException {

        String savePath = this.getServletConfig().getServletContext().getRealPath("") + folder; //保存文件的路径
        File f1 = new File(savePath);

        if (!f1.exists()) {
            f1.mkdirs();
        }
        //这个是文件上传需要的类,具体去百度看看,现在只管使用就好
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
//	        upload.setHeaderEncoding("utf-8");
        List fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            return null;
        }
        //迭代器,搜索前端发送过来的文件
        Iterator<FileItem> it = fileList.iterator();
        String name = "";
        String extName = "";
        while (it.hasNext()) {
            FileItem item = it.next();
            //判断该表单项是否是普通类型
            if (!item.isFormField()) {
                name = item.getName();
                long size = item.getSize();
                String type = item.getContentType();

                //  System.out.println("文件大小"+size + " 文件类型" + type);

                if (name == null || name.trim().equals("")) {
                    continue;
                }
                // 扩展名格式： extName就是文件的后缀,例如 .txt
                if (name.lastIndexOf(".") >= 0) {
                    extName = name.substring(name.lastIndexOf("."));
                }
                File file = null;
                do {
                    // 生成文件名：
                    name = UUID.randomUUID().toString();
                    file = new File(savePath + name + extName);
                } while (file.exists());
//	                File saveFile = new File(savePath + name + extName);
                try {
                    item.write(file);//保存
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        HttpSession fsession = request.getSession();
        fsession.setAttribute(Constants.FILE_NAME, name + extName);

        return (name + extName);//返回文件名及后缀

//	        response.getWriter().print(request.getContextPath()+"/upload/" + name + extName);//返回生成的文件名及后缀

    }


}
