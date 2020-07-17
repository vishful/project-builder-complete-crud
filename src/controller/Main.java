package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.CrudDAO;
import dao.UserDAO;
import model.Blog;
import model.User;
import service.RegistrationValidation;
import service.ValidateUserFields;
import utility.ConnectionManager;

public class Main {

	public static void main(String[] args) throws Throwable {
		
		// Check if connection is working or not
		
//		Connection con=null;
//		
//		con = ConnectionManager.getConnection();
//		if(con!=null)
//			System.out.println("Connection Established");
//		else 
//			System.out.println("Check connection");
		
		System.out.println("1. Registration");
		System.out.println("2. Login");
		System.out.println("3. Create");
		System.out.println("4. Read");
		System.out.println("5. Update");
		System.out.println("6. Delete");
		Blog blog = new Blog();
		CrudDAO cruddao =  new CrudDAO();
		ValidateUserFields valid=new ValidateUserFields();
		RegistrationValidation reg=new RegistrationValidation();
		List<Blog> blogList = new ArrayList<Blog>();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice = Integer.parseInt(br.readLine());
		
		switch (choice) {
		case 1:
			System.out.println("Enter e-mail");
			String email=br.readLine();
			System.out.println("Enter password");
			String password=br.readLine();
			System.out.println("Enter password again");
			String confirmPassword=br.readLine();
			reg.checkUserDetails(email, password, confirmPassword);
			break;
			
		case 2:
			System.out.println("Enter e-mail");
			String email1=br.readLine();
			System.out.println("Enter password");
			String password1=br.readLine();
			valid.validate(email1, password1);
			break;
			
		case 3:
			System.out.println("Create");
			String blogTitle = br.readLine();
			String blogDescription = br.readLine();
			LocalDate postedOn = LocalDate.now();
			blog.setBlogTitle(blogTitle);
			blog.setBlogDescription(blogDescription);
			blog.setPostedOn(postedOn);
			cruddao.insertBlog(blog);
			
			
			break;
		case 4:
			System.out.println("Read");
			blogList = cruddao.selectAllBlogs();
			if(blogList!=null)
			{
			for(Blog blogs:blogList) {
				System.out.println(blogs.getBlogId());
				System.out.println(blogs.getBlogTitle());
				System.out.println(blogs.getBlogDescription());
				System.out.println(blogs.getPostedOn());
			}
			}
			else {
				System.out.println(blogList);
			}
			break;
		case 5:
			System.out.println("Update");
			int id = Integer.parseInt(br.readLine());
			String blog_title = br.readLine();
			String blog_description = br.readLine();
			LocalDate posted_On = LocalDate.now();
			
			blog.setBlogId(id);
			blog.setBlogTitle(blog_title);
			blog.setBlogDescription(blog_description);
			blog.setPostedOn(posted_On);
			cruddao.updateBlog(blog);
			break;
		case 6:
			System.out.println("Delete");
			int blogid = Integer.parseInt(br.readLine());
			cruddao.deleteBlog(blogid);
			break;
			
		
		
		
		
		
		
		
		
		}
		

	}

}