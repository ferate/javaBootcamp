package homework;

import java.util.Date;

import homework.models.Lecture;
import homework.models.User;
import homework.services.LectureService;
import homework.services.UserService;

public class Main {

	public static void main(String[] args) {
		/**
		 * User Service
		 */
		UserService userService = new UserService();
		
		User user1 = new User(1,"Karcan","Özbal","karcanozbal@outlook.com.tr","karcan","deneme12345");
		User user2 = new User(2,"Ömer","Acar","acar.0mer@hotmail.com","omer","deneme12345");
		User user3 = new User(3,"Uğur","Yıldız","","ugur","deneme12345");
		User user4 = new User(4,"Pinar","Darıcı","","pinar","deneme12345");
		
		// single adding method. 
		userService.add(user1);
		
		// multiple adding method.
		User[] users = {user2,user3,user4};
		userService.add(users);
		
		// business rule testing for user name length.
		System.out.println("");
		User user5 = new User(5,"Haşim Ahmet Abdulbaki Buğra Bahadır","Nebioğulları","","hasim","deneme12345");
		userService.add(user5);
		
		// update user before get all list 
		user4.name = "Pınar";
		userService.update(user4);
		
		// delete user before get all list
		userService.delete(user3);

		
		// get all user list. 
		System.out.println("");
		System.out.println("id	name	surname");
		System.out.println("--	----	-------");
		for (User user : userService.getAll()) {
			System.out.println(user.id + "	" + user.name + "	" + user.surname);
		} 
		
		// get user by id;
		System.out.println(userService.getById(2).name);
		
		// -----------------------------------------------------------------
		
		
		/**
		 * Lecture Service
		 */
		System.out.println("");
		LectureService lectureService = new LectureService();
		
		Lecture lecture1 = new Lecture(1,1,"Ders 1",new Date());
		Lecture lecture2 = new Lecture(2,1,"Ders 2",new Date());
		Lecture lecture3 = new Lecture(3,1,"Ders 3",new Date());
		Lecture lecture4 = new Lecture(4,1,"Ders 4",new Date());
		Lecture lecture5 = new Lecture(5,1,"Ders 5",new Date());
		
		// single adding method.
		lectureService.add(lecture1);
		
		// multiple adding method.
		Lecture[] lectures = {lecture2,lecture3,lecture4,lecture5};
		lectureService.add(lectures);
		
		// get all lecture list.
		System.out.println("");
		System.out.println("id	courseId	name	date");
		System.out.println("--	--------	----	----");
		for (Lecture lecture : lectureService.getAll()) {
			System.out.println(lecture.id + "	" + lecture.courseId + "		" + lecture.name + "	" + lecture.date);
		}
		
		// get lectures by id.
		System.out.println("");
		System.out.println("id	courseId	name	date");
		System.out.println("--	--------	----	----");
		for (Lecture lecture : lectureService.getAllById(2)) {
			System.out.println(lecture.id + "	" + lecture.courseId + "		" + lecture.name + "	" + lecture.date);
		}
		
		// get lectures by courseId.
		System.out.println("");
		System.out.println("id	courseId	name	date");
		System.out.println("--	--------	----	----");
		for (Lecture lecture : lectureService.getAllByCourseId(1)) {
			System.out.println(lecture.id + "	" + lecture.courseId + "		" + lecture.name + "	" + lecture.date);
		}
		
		
	}

}
