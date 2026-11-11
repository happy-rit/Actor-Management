package springCore.Main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Class.Actor;
import com.Configuration.ActorConfiguration;
import com.Dao.ActorDao;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context	= new AnnotationConfigApplicationContext(ActorConfiguration.class);
		ActorDao bean = context.getBean(ActorDao.class);
		while(true)
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Operations to Perform");
			System.out.println("1 : Insert Actor Details");
			System.out.println("2 : Update Actor Details");
			System.out.println("3 : Delete Actor Details");
			System.out.println("4 : Get Actor Details by ID");
			System.out.println("5 : Get All Actor Details");
			System.out.println("6 : Exit Application");
			System.out.println();
			System.out.println("Enter Choice which u want to perform");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1 :
					System.out.println("You want to insert actor details");
					System.out.println();
					Actor a = new Actor();
					System.out.println("Enter Actor Id");
					int id = sc.nextInt();
					System.out.println("Enter Actor Name");
					String name = sc.next();
					System.out.println("Enter Actor Email");
					String email = sc.next();
					sc.next();
					System.out.println("Enter Actor Salary");
					double salary = sc.nextDouble();
					System.out.println("Enter Actor Movie");
					String movie = sc.next();
					
					a.setActor_Id(id);
					a.setActor_Name(name);
					a.setActor_Email(email);
					a.setActor_Salary(salary);
					a.setActor_Movie(movie);
					
					int insert = bean.insertA(a);
					if(insert>0)
					{
						System.out.println();
						System.out.println("Actor added successfully");
						System.out.println();
					}
					else
					{
						System.out.println("Actor not added something went wrong !...");
					}
					System.out.println();
					break;
					
			case 2 :
					System.out.println("You want to update actor details");
					System.out.println();
					System.out.println("Enter actor-email to update it");
					String mail = sc.next();
					System.out.println("Enter actor-salary to update it");
					double sal = sc.nextDouble();
					System.out.println("Enter actor-id u want to update");
					int id1 = sc.nextInt();
					
					int update = bean.updateA(mail, sal, id1);
					if(update>0)
					{
						System.out.println();
						System.out.println("Actor details updated successfully");
						System.out.println();
					}
					else
					{
						System.out.println("Actor details not updated something went wrong !...");
					}
					System.out.println();
					break;
					
			case 3 :
					System.out.println("You want to delete actor details");
					System.out.println();
					System.out.println("Enter actor-id u want to delete");
					int id2 = sc.nextInt();
					
					int delete = bean.deleteA(id2);
					if(delete>0)
					{
						System.out.println();
						System.out.println("Actor details deleted successfully");
						System.out.println();
					}
					else
					{
						System.out.println("Actor details not deleted something went wrong !...");
					}
					System.out.println();
					break;
					
			case 4 : 
					System.out.println("You want actor details by its id");
					System.out.println();
					System.out.println("Enter actor-id u want to see the details");
					int id3 = sc.nextInt();
					Actor byId = bean.getById(id3);
					System.out.println(byId);
					System.out.println();
					break;
					
			case 5 :
					System.out.println("All the Actors Details are : ");
					bean.getAllActor().forEach(System.out::println);
					System.out.println();
					break;
					
			case 6 :
					System.out.println("\nThank you for using Actor Management System !...");
					System.out.println("Your application is closing. Have a great day !...");
					System.exit(0);
					System.out.println();
					break;
					
			default :
					System.out.println("Enter details invalid");
					System.out.println();
					break;
			}
			
		}
		
	}

}
