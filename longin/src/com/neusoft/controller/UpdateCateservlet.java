package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Cate;
import com.neusoft.services.CateSerice;


/**
 * Servlet implementation class UpdateCateservlet
 */
@WebServlet("/UpdateCateservlet")
public class UpdateCateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCateservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		CateSerice cs=new CateSerice();
		//��ѯ��ȫ����Ϣ
		List<Cate> selectList=cs.checkCateList();
		request.setAttribute("selectList",selectList );
		
		//�õ�ɾ����һ�е�cid
		String getCid=request.getParameter("getcid");
		
		//�õ�ȷ�ϰ�ť��ֵ
		String button_value=request.getParameter("button_name");
		System.out.println(button_value);		
		//�ж�button_value��ֵ
		if(button_value!=null&&!button_value.equals("")) {
			if(button_value.equals("yes")) { 
				String getCname=request.getParameter("update_input");
				//�õ�������ĸ����cid
				System.out.println(getCname);
				
				String getPartentcid=request.getParameter("select_partent");
				//˵��input����������ֵ
				if(getCname!=null&&!getCname.equals("")) {
					
					int _getpid=Integer.parseInt(getPartentcid);
					System.out.println(_getpid);
					
					String getCid2=request.getParameter("type");
					System.out.println(getCid2);
					int _getcid=Integer.parseInt(getCid2);
					Cate cate01=new Cate(_getcid,getCname,_getpid);
					boolean flag=cs.updateCate(cate01);
					System.out.println("�޸ĳɹ�����"+flag);
					request.getRequestDispatcher("CateServlet").forward(request, response);
				}else {//û������ֵ
					int _getcid=Integer.parseInt(getCid);
					int _getpid=Integer.parseInt(getPartentcid);
					//ѭ������ȫ���ı��õ�����һҳ��cid��ͬ��cname�ٸ�ֵ
					String getcname02="as";
					 for(int i=0;i<selectList.size();i++){
						 if(selectList.get(i).getCid()==_getcid){
							 getCname=selectList.get(i).getCname();
						    }
					 }
					 Cate cate01=new Cate(_getcid,getcname02,_getpid);
					 cs.updateCate(cate01);
					 request.getRequestDispatcher("CateServlet").forward(request, response);
				}
			}else {//����˳�
				System.out.println("û�ж�ȡ����ȡ��");
				request.getRequestDispatcher("CateServlet").forward(request, response);
			}
		}
		//�״ν���ִ��
		else{
			int cid=Integer.parseInt(getCid);
			System.out.println("�����޸Ľ������cid=="+cid);
			request.setAttribute("getcid", cid);
			request.getRequestDispatcher("upcate.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
