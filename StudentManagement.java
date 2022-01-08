import java.util.*;
class StudentManagement{
	public final static void clearConsole(){
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e) {
			e.printStackTrace();
		// Handle any exceptions.
		}
	}
	
	public static int sortDBMSMarks(String[][] student, int[] sortedDBMSMarks, int index){
		int[] dBMarks = new int[100];
		
		//To store the DBMS Marks of every student in array dBMarks and then copy them into the array sortedDBMSMarks 
		//Marks get copied in the same order
	L1: for (int i = 0; i < student.length; i++){
			if(student[i][2] != null & student[i][3] != null){
				dBMarks[i] = Integer.parseInt(student[i][3]);
				sortedDBMSMarks[i] = dBMarks[i];
			}else{
				continue L1;
			}
		}
		
		//Bubble Sort - arranges the DBMS marks in array sortedDBMSMarks in the descending order
	L2: for (int j = 0; j < student.length; j++){
			for (int k = 0; k < student.length-1; k++){
				if(sortedDBMSMarks[k] < sortedDBMSMarks[k+1]){
					int x = sortedDBMSMarks[k+1];
					sortedDBMSMarks[k+1] = sortedDBMSMarks[k];
					sortedDBMSMarks[k] = x; 
				}
			}	
		}
		
		//Finds the index of the student with the respective sorted PF Mark.
	L3:	for (int x = index; x < student.length; x++){
		L4: for (int y = 0; y < student.length; y++){
				if(sortedDBMSMarks[x] == dBMarks[y]){
					index = y;
					break L3;
				}
				if(sortedDBMSMarks[x] != dBMarks[y]){
					continue L4;
				}
			}
		}
		return index;
	}
		
	public static int sortPFMarks(String[][] student, int[] sortedPFMarks, int index){
		int[] pFMarks = new int[100];
		
		//To store the PF Marks of every student in array pFMarks and then copy them into the array sortedPFMarks 
		//Marks get copied in the same order		
	L1: for (int i = 0; i < student.length; i++){
			if(student[i][2] != null & student[i][3] != null){
				pFMarks[i] = Integer.parseInt(student[i][2]);
				sortedPFMarks[i] = pFMarks[i];
			}else{
				continue L1;
			}
		}
		
		//Bubble Sort - arranges the PF marks in array sortedPFMarks in the descending order
	L2: for (int j = 0; j < student.length; j++){
			for (int k = 0; k < student.length-1; k++){
				if(sortedPFMarks[k] < sortedPFMarks[k+1]){
					int x = sortedPFMarks[k+1];
					sortedPFMarks[k+1] = sortedPFMarks[k];
					sortedPFMarks[k] = x; 
				}
			}			
			
		}
		
		//Finds the index of the student with the respective sorted PF Mark.
	L3:	for (int x = index; x < student.length; x++){
		L4: for (int y = 0; y < student.length; y++){
				if(sortedPFMarks[x] == pFMarks[y]){
					index = y;
					break L3;
				}
				if(sortedPFMarks[x] != pFMarks[y]){
					continue L4;
				}
			}
		}
		return index;
	}
	
	public static int getRank(String[][] student, double[] avgMarks, double[] sortAvg, int index){
		
		//To copy the values of array avgMarks to array sortAvg (also refered as rank)                 
	L1: for (int i = 0; i < student.length; i++){
				sortAvg[i] = avgMarks[i];
		}
		
		//Bubble Sort - arrange the avg marks in array sortAvg in the descending order
	L2: for (int j = 0; j < student.length; j++){
			for (int k = 0; k < student.length-1; k++){
				if(sortAvg[k] < sortAvg[k+1]){
					double x = sortAvg[k+1];
					sortAvg[k+1] = sortAvg[k];
					sortAvg[k] = x; 
				}
			}			
			
		}
		
		//Finds the index of the student with the respective sorted Average Mark.
	L3:	for (int x = index; x < student.length; x++){
		L4: for (int y = 0; y < student.length; y++){
				if(sortAvg[x] == avgMarks[y]){
					index = y;
					break L3;
				}
				if(sortAvg[x] != avgMarks[y]){
					continue L4;
				}
			}
		}
		return index;
	}
		
	public static int findRankIndex(double[] avgMarks, double[] rank, int index){
		int rankIndex = -1;
	L1: for (int i = 0; i < rank.length; i++){
			if(avgMarks[index] == rank[i]){
				rankIndex = i;
				break L1;
			}else{
				continue L1;
			}
		}
		return rankIndex;		
	}
	
	public static void findAvgMarks(String[][] student, double[] avgMarks){
		//double avg = 0;
	L1: for (int i = 0; i < student.length; i++){
			if(student[i][2] != null & student[i][3] != null){
				avgMarks[i] = (Integer.parseInt(student[i][2]) + Integer.parseInt(student[i][3])) / 2.0;
			}
			if(student[i][2] == null & student[i][3] == null){
				continue L1;
			}
		}
	}
	
	public static void findTotalMarks(String[][] student, int[] totalMarks){

		L1: for (int i = 0; i < student.length; i++){
			if(student[i][2] != null & student[i][3] != null){
				totalMarks[i] = Integer.parseInt(student[i][2]) + Integer.parseInt(student[i][3]);
			}
			if(student[i][2] == null & student[i][3] == null){
				continue L1;
			}
		}
	}
	
	public static int searchIndex(String[][] student, String studId){
		Scanner input = new Scanner(System.in);
		int index = -1;
		L1:for (int j = 0; j < student.length; j++){
			if(studId.equals(student[j][0])){
				index = j;
				break L1;
			}else if(student[j][0] != null){
				continue L1;
			}else if(student[j][0] == null){
				
			L2: for (int k = 0; k < 4; k++){
					if(student[k][0] == studId){
						index = k;
						break L1;
					}
				}
			}
		}
		return index;
	}
		
	public static void findBestInDBMS(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){
		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mBEST IN DATABASE MANAGEMENT SYSTEM\033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
	
		Scanner input = new Scanner(System.in);
		int index = 0;
		int[] sortedDBMSMarks = new int[100];
		
		//---Top Border--------------------
	
		System.out.print("+");
		for (int x  = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x < 31; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 10; x++){
			System.out.print("-");
		}
		System.out.println("+");
		//--------------------------
		
		System.out.print("|ID");
		System.out.print("\t     |Name");
		System.out.print("\t\t\t     |DBMS Marks ");
		System.out.println(" |PF Marks  |");
		
		//---Headings-Bottom Border-------
		
		System.out.print("+");
		for (int x  = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x < 31; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 10; x++){
			System.out.print("-");
		}
		System.out.println("+");
		//-----------------------------------
			
		L1: for (int i = 0; i < student.length; i++){
				if(student[i][2] != null & student[i][3] != null){
					index = sortDBMSMarks(student,sortedDBMSMarks,i);
					
					System.out.println("|"+student[index][0]+" \t|"+student[index][1]+" \t\t\t\t|\t  "+sortedDBMSMarks[i]+"|\t"+student[index][2]+"|");
				}else if(student[i][2] == null & student[i][3] == null){
					continue L1;
				}
			}
			
		//---Bottom Border-------------------

		System.out.print("+");
		for (int x  = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x < 31; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 10; x++){
			System.out.print("-");
		}
		System.out.println("+");
		//----------------------------------
		System.out.println();
		
		System.out.print("Do you want to go back to main menu? (y/n) : ");
		String yesNo = input.next();
		System.out.println();
		switch(yesNo){
			case("y"):
				clearConsole();
				homePage(student,totalMarks,avgMarks,rank);
			case("n"):
				clearConsole();
				findBestInDBMS(student,totalMarks,avgMarks,rank);			
		}
	}
	
	public static void findBestInPF(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){
		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mBEST IN PROGRAMMING FUNDAMENTALS\033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		
		Scanner input = new Scanner(System.in);
		int index = 0;
		int[] sortedPFMarks = new int[100];
		
		//---Top Border--------------------

		System.out.print("+");
		for (int x  = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x < 31; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 10; x++){
			System.out.print("-");
		}
		System.out.println("+");
		//--------------------------
		
		//System.out.print("|Rank");
		System.out.print("|ID");
		System.out.print("\t     |Name");
		System.out.print("\t\t\t     |DBMS Marks ");
		System.out.println(" |PF Marks  |");
		
		//---Headings-Bottom Border-------

		System.out.print("+");
		for (int x  = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x < 31; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 10; x++){
			System.out.print("-");
		}
		System.out.println("+");
		//-----------------------------------
		
		L1: for (int i = 0; i < student.length; i++){
				if(student[i][2] != null & student[i][3] != null){
					index = sortPFMarks(student,sortedPFMarks,i);
					
					System.out.println("|"+student[index][0]+"\t     |"+student[index][1]+"   \t\t\t|\t  "+sortedPFMarks[i]+"|\t   "+student[index][3]+"|");
				}
				if(student[i][2] == null & student[i][3] == null){
					continue L1;
				}
			}
		
		//---Bottom Border-------------------
	
		System.out.print("+");
		for (int x  = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x < 31; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 10; x++){
			System.out.print("-");
		}
		System.out.println("+");
		//----------------------------------
		System.out.println();
		
		System.out.print("Do you want to go back to main menu? (y/n) : ");
		String yesNo = input.next();
		System.out.println();
		switch(yesNo){
			case("y"):
				clearConsole();
				homePage(student,totalMarks,avgMarks,rank);
			case("n"):
				clearConsole();
				findBestInPF(student,totalMarks,avgMarks,rank);			
		}
	}
		
	public static void printStudentRank(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){
		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mPRINT STUDENTS' RANKS\033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		
		Scanner input = new Scanner(System.in);
		int index = 0;

		findAvgMarks(student,avgMarks);
		findTotalMarks(student,totalMarks);
		
		//---Top Border-------------------- 
		
		System.out.print("+");
		for (int x = 0; x < 10; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x < 31; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 10; x++){
			System.out.print("-");
		}
		System.out.println("+");
		//--------------------------
		
		System.out.print("|Rank");
		System.out.print("\t   |ID");
		System.out.print(" \t\t|Name");
		System.out.print("\t\t\t\t|Total Marks ");
		System.out.println("|Avg. Marks|");
		
		//---Headings-Bottom Border-------
		
		System.out.print("+");
		for (int x = 0; x < 10; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x < 31; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x = 0; x  < 12; x++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int x  = 0; x  < 10; x++){
			System.out.print("-");
		}
		System.out.println("+");
		//------------------------------
		
		L1: for (int i = 0; i < student.length; i++){
				if(student[i][2] != null & student[i][3] != null){
					index = getRank(student,avgMarks,rank,i);
					
					System.out.print("|"+(++i)+"\t   |"+student[index][0]+" \t|"+student[index][1]+" \t\t\t\t|\t  "+totalMarks[index]+"|\t   ");
					System.out.printf("%.2f",avgMarks[index]);
					System.out.println("|");
					i--;
				}
				if(student[i][2] == null & student[i][3] == null){
					continue L1;
				}
			}
			
			//---Bottom Border-------------------
			
			System.out.print("+");
			for (int x = 0; x < 10; x++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int x  = 0; x  < 12; x++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int x = 0; x < 31; x++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int x = 0; x  < 12; x++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int x  = 0; x  < 10; x++){
				System.out.print("-");
			}
			System.out.println("+");
			//----------------------------------
			System.out.println();
			
			System.out.print("Do you want to go back to main menu? (y/n) : ");
			String yesNo = input.next();
			System.out.println();
			switch(yesNo){
				case("y"):
					clearConsole();
					homePage(student,totalMarks,avgMarks,rank);	
				case("n"):
					clearConsole();
					printStudentRank(student,totalMarks,avgMarks,rank);			
			}
		
	}
	
	public static void printStudentDetails(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){
		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mPRINT STUDENT DETAILS\033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		
		Scanner input = new Scanner(System.in);
		int index = -1;
		int rankIndex = 0;
		
		L1:	for (int i = 0; i < student.length; i++){
			System.out.print("Enter Student ID\t: ");
			String studId = input.next();
			if (studId.indexOf("S") == 0){
				L2: for (int j = 0; j < student.length; j++){
					index = searchIndex(student,studId);
					
					if(index != -1){
						System.out.println("Student Name\t\t: "+student[index][1]);
						System.out.println();
					
						if(student[index][2] == null & student[index][3] == null){
							System.out.println("Marks yet to be added. ");
							System.out.println();
							System.out.print("Do you want to search another student's details? (y/n) : ");
							String yesNo = input.next();
							System.out.println();
							
							switch(yesNo){
								case("y"):
									clearConsole();
									printStudentDetails(student,totalMarks,avgMarks,rank);
									continue L1;
								case("n"):
									clearConsole();
									homePage(student,totalMarks,avgMarks,rank);				
							}
						}else if(student[index][2] != null & student[index][3] != null){
							findTotalMarks(student,totalMarks);
							//totalMarks= Arrays.stream(totalMarks).asDoubleStream().toArray();
							findAvgMarks(student,avgMarks);
							
							System.out.print("+");
							for (int x = 0; x < 40; x++){
								System.out.print("-");
							}
							System.out.print("+");
							for (int y = 0; y < 22; y++){
								System.out.print("-");
							}
							System.out.println("+");
							
							//System.out.printf("%.2f",avg);
							System.out.println("|Programming Fundamentals Marks\t\t | "+student[index][2]+"\t\t\t|");
							System.out.println("|Database Management System Marks\t | "+student[index][3]+"\t\t\t|");
							System.out.println("|Total Marks\t\t\t\t | "+totalMarks[index]+"\t\t\t|");
							System.out.print("|Average Marks\t\t\t\t | ");
							System.out.printf("%.2f",avgMarks[index]);
							System.out.println("\t\t|");
							
							getRank(student,avgMarks,rank,index);
							rankIndex = findRankIndex(avgMarks,rank,index);
							
							System.out.println("|Rank\t\t\t\t\t | "+(++rankIndex)+"\t\t\t|");
							
							System.out.print("+");
							for (int x = 0; x < 40; x++){
								System.out.print("-");
							}
							System.out.print("+");
							for (int y = 0; y < 22; y++){
								System.out.print("-");
							}
							System.out.println("+");
							System.out.println();
							
							break L2;
						}
					}
				}
				System.out.println("No student with ID "+studId+"...");
				System.out.print("Do yo want to search another student's details? (y/n) : ");
				String yesNo = input.next();
				System.out.println();
				switch(yesNo){
					case("y"):
						clearConsole();
						printStudentDetails(student,totalMarks,avgMarks,rank);
					case("n"):
						clearConsole();
						homePage(student,totalMarks,avgMarks,rank);				
				}
				
			}else{
				System.out.print("Invalid Student ID. ");
				System.out.print("Do yo want to search again? (y/n) : ");
				String yesNo = input.next();
				System.out.println();
				switch(yesNo){
					case("y"):
						clearConsole();
						continue L1;
					case("n"):
						clearConsole();
						homePage(student,totalMarks,avgMarks,rank);			
				}
			}
		}	
	}
	
	public static void deleteStudent(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){
		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mDELETE STUDENT \033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		
		Scanner input = new Scanner(System.in);
		int index = -1;
		L1:	for (int i = 0; i < student.length; i++){
			System.out.print("Enter Student ID\t: ");
			String studId = input.next();
			if (studId.indexOf("S") == 0){
				L2: for (int j = 0; j < student.length; j++){
					index = searchIndex(student,studId);
					
					if(index != -1){
						System.out.println("Student Name\t\t: "+student[index][1]);
						System.out.println();
					
						for (int k = 0; k < student[index].length; k++){
							student[index][k] = null;
						}
					}else{
						System.out.print("No student with ID "+studId+". ");
						System.out.print("Do yo want to search again? (y/n) : ");
						String yesNo = input.next();
						System.out.println();
						System.out.println();
						
						switch(yesNo){
							case("y"):
								continue L1;
							case("n"):
								clearConsole();
								homePage(student,totalMarks,avgMarks,rank);				
						}
						
					}
					//--
					//System.out.println(Arrays.toString(student[0]));
					//System.out.println(Arrays.toString(student[1]));
					//System.out.println(Arrays.toString(student[2]));
					//System.out.println(Arrays.toString(student[3]));
					//System.out.println(Arrays.toString(student[4]));
					//System.out.println();
					//--
					System.out.println("Student has been deleted successfully.");
					System.out.print("Do you want to delete another student? (y/n) : ");
					String yesNo = input.next();
					System.out.println();
					switch(yesNo){
						case("y"):
							clearConsole();
							deleteStudent(student,totalMarks,avgMarks,rank);
							//continue L1; //to prevent the loop repeating again from i=0
						case("n"):
							clearConsole();
							homePage(student,totalMarks,avgMarks,rank);				
					}
					
				}
			}else{
				System.out.print("Invalid Student ID. ");
				System.out.print("Do yo want to search again? (y/n) : ");
				String yesNo = input.next();
				System.out.println();
				switch(yesNo){
					case("y"):
						clearConsole();
						//deleteStudent(student);
						continue L1;
					case("n"):
						clearConsole();
						homePage(student,totalMarks,avgMarks,rank);				
				}
			}
		}
	}
	
	public static void updateMarks(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){
		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mUPDATE MARKS \033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		Scanner input = new Scanner(System.in);
		int index = 0;
		L1:	for (int i = 0; i < student.length; i++){
			System.out.print("Enter Student ID\t: ");
			String studId = input.next();
			if (studId.indexOf("S") == 0){
			//index = searchIndex(student);
				
			L2: for (int j = 0; j < student.length; j++){
				index = searchIndex(student,studId);
				
				System.out.println("Student Name\t\t: "+student[index][1]);
				System.out.println();
				
				if(student[index][2] != null & student[index][3] != null){
					System.out.println("Programming Fundamentals Marks\t\t: "+student[index][2]);
					System.out.println("Database Management System Marks\t: "+student[index][3]);
					System.out.println();
					
					L3:	for (int k = 0; k < student.length; k++){
							System.out.print("Enter new Programming Fundamentals Marks\t: ");
							int progFMarks = input.nextInt();
							if(progFMarks >= 0 & progFMarks <= 100){
								student[index][2] = (progFMarks+"");
								break L3;
							}else{
								System.out.print("Invalid marks, please enter correct marks...");
								System.out.println();
							}
						}
					
					L4:	for (int l = 0; l < student.length; l++){
							System.out.print("Enter new Database Management System Marks\t: ");
							int dbmsMarks = input.nextInt();
							if(dbmsMarks >= 0 & dbmsMarks <= 100){
								student[index][3] = (dbmsMarks+"");
								break L4;
							}else{
								System.out.print("Invalid marks please enter correct marks...");
								System.out.println();
							}
						}
						//--
						//System.out.println(Arrays.toString(student[0]));
						//System.out.println(Arrays.toString(student[1]));
						//System.out.println(Arrays.toString(student[2]));
						//System.out.println(Arrays.toString(student[3]));
						//System.out.println(Arrays.toString(student[4]));
						//System.out.println();
						//--
						System.out.println();
						System.out.println("Marks has been added successfully...");
						System.out.print("Do you want to update the marks for another student? (y/n) : ");
						String yesNo = input.next();
						System.out.println();
						
						switch(yesNo){
							case("y"):
								clearConsole();
								updateMarks(student,totalMarks,avgMarks,rank);
							case("n"):
								clearConsole();
								homePage(student,totalMarks,avgMarks,rank);			
						}
					}else if(student[index][2] == null & student[index][3] == null){
						System.out.println("This student's marks yet to be added. ");
						System.out.print("Do you want to update the marks for another student? (y/n) : ");
						String yesNo = input.next();
						System.out.println();
						
						switch(yesNo){
							case("y"):
								clearConsole();
								updateMarks(student,totalMarks,avgMarks,rank);
							case("n"):
								clearConsole();
								homePage(student,totalMarks,avgMarks,rank);				
						}
					}
				
				}
				
			}else{
				System.out.print("Invalid Student ID. ");
				System.out.print("Do yo want to search again? (y/n) : ");
				String yesNo = input.next();
				System.out.println();
				switch(yesNo){
					case("y"):
						clearConsole();
						//updateMarks(student);
						continue L1;
					case("n"):
						clearConsole();
						homePage(student,totalMarks,avgMarks,rank);			
				}
			}
		}
	}
	
	public static void updateStudentDetails(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){
		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mUPDATE STUDENT DETAILS \033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		
		Scanner input = new Scanner(System.in);
		int index = -1;
		
	L1:	for (int i = 0; i < student.length; i++){
			System.out.print("Enter Student ID\t: ");
			String studId = input.next();
			if (studId.indexOf("S") == 0){
				
			L2: for (int j = 0; j < student.length; j++){
				
					index = searchIndex(student,studId);
					
					System.out.println("Student Name\t\t: "+student[index][1]);
					System.out.println();
					
					System.out.print("Enter the new student Name\t: ");
					student[index][1] = input.next();
					System.out.println();
					
					System.out.println(Arrays.toString(student[0]));
					System.out.println(Arrays.toString(student[1]));
					System.out.println(Arrays.toString(student[2]));
					System.out.println(Arrays.toString(student[3]));
					System.out.println(Arrays.toString(student[4]));
					System.out.println();
					
					System.out.println("Student details has been updated successfully.");
					System.out.print("Do you want to update another student's details? (y/n): ");
					String yesNo = input.next();
					System.out.println();
					
					switch(yesNo){
						case("y"):
							clearConsole();
							updateStudentDetails(student,totalMarks,avgMarks,rank);
							//continue L1;
						case("n"):
							clearConsole();
							homePage(student,totalMarks,avgMarks,rank);			
					}
				}
				
			}else{
				System.out.print("Invalid Student ID. ");
				System.out.print("Do yo want to search again? (y/n) : ");
				String yesNo = input.next();
				System.out.println();
				switch(yesNo){
					case("y"):
						clearConsole();
						//updateStudentDetails(student);
						continue L1;
					case("n"):
						clearConsole();
						homePage(student,totalMarks,avgMarks,rank);		
				}
			}
		}
	}
	public static void addMarks(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){
		
		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mADD MARKS \033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		Scanner input = new Scanner(System.in);
		int index = -1;
		
	L5:	for (int i = 0; i < student.length; i++){
			System.out.print("Enter Student ID\t: ");
			String studId = input.next();
			if (studId.indexOf("S") == 0){
					
			L6:	for (int j = 0; j < student.length; j++){
				
					index = searchIndex(student,studId);
					
					System.out.print("Student Name\t\t: "+student[index][1]);
					System.out.println();
						
					if(student[index][2] == null & student[index][3] == null){
						
						L7:	for (int k = 0; k < student.length; k++){
								System.out.print("Programming Fundamentals Marks\t\t: ");
								int progFMarks = input.nextInt();
								if(progFMarks >= 0 & progFMarks <= 100){
									student[index][2] = (progFMarks+"");
									break L7;
								}else{
									System.out.print("Invalid marks, please enter correct marks...");
									System.out.println();
									//continue L3;
								}
							}
						
						L8:	for (int l = 0; l < student.length; l++){
								System.out.print("Database Management System Marks\t: ");
								int dbmsMarks = input.nextInt();
								if(dbmsMarks >= 0 & dbmsMarks <= 100){
									student[index][3] = (dbmsMarks+"");
									break L8;
								}else{
									System.out.print("Invalid marks please enter correct marks...");
									System.out.println();
									System.out.println();
								}
							}
							
							//--
							//System.out.println(Arrays.toString(student[0]));
							//System.out.println(Arrays.toString(student[1]));
							//System.out.println(Arrays.toString(student[2]));
							//System.out.println(Arrays.toString(student[3]));
							//System.out.println(Arrays.toString(student[4]));
							//System.out.println();
							//--
							
							System.out.print("Marks have been added. ");
							System.out.print("Do you want to add marks for another student? (y/n) : ");
							String yOrN = input.next();
							System.out.println();
							
							switch(yOrN){
								case("y"):
									clearConsole();
									addMarks(student,totalMarks,avgMarks,rank);
									//continue L5;
								case("n"):
									clearConsole();
									homePage(student,totalMarks,avgMarks,rank);
								default: System.out.println("Invalid input...");				
							}
							
					}else{
						System.out.println("This student's marks have been already added. ");
						System.out.println("If you want to update the marks, please use [4] Update Marks Option");
						System.out.println();
						System.out.print("Do you want to search again? (y/n) : ");
						String yesNo = input.next();
						System.out.println();
						
						switch(yesNo){
							case("y"):
								continue L5; // executes in the same page
							case("n"):
								clearConsole();
								homePage(student,totalMarks,avgMarks,rank);
							default: System.out.println("Invalid input...");				
						}
					}
					System.out.println();
				}
			}else{
				System.out.print("Invalid Student ID, please enter correct Student ID...");
				System.out.println();
				continue L5;
			}
		}
	}


	public static void addNewStudentWithMarks(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){

		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mADD NEW STUDENT WITH MARKS \033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		Scanner input = new Scanner(System.in);
		
	L1:	for (int i = 0; i < student.length; i++){
			System.out.print("Enter Student ID\t: ");
			String studId = input.next();
			if (studId.indexOf("S") == 0){
			
			L2:	for (int j = 0; j < student.length; j++){
					if(studId.equals(student[j][0])){
						System.out.print("This student ID already exists...");
						System.out.println();
						//j--;
						continue L1;
					}else if((student[j][0]) == null){
					
						student[j][0] = studId;
						System.out.print("Enter Student Name\t: ");
						student[j][1] = input.next();
						System.out.println();
						//continue L1;
					
		
					L3:	for (int k = 0; k < student.length; k++){
							System.out.print("Programming Fundamentals Marks\t\t: ");
							int progFMarks = input.nextInt();
							if(progFMarks >= 0 & progFMarks <= 100){
								student[j][2] = (progFMarks+"");
								break L3;
							}else{
								System.out.print("Invalid marks, please enter correct marks...");
								System.out.println();
								//continue L3;
							}
						}
						
					L4:	for (int l = 0; l < student.length; l++){
							System.out.print("Database Management System Marks\t: ");
							int dbmsMarks = input.nextInt();
							if(dbmsMarks >= 0 & dbmsMarks <= 100){
								student[j][3] = (dbmsMarks+"");
								break;
							}else{
								System.out.print("Invalid marks please enter correct marks...");
								System.out.println();
							}
						}
						//--
						//System.out.println(Arrays.toString(student[0]));
						//System.out.println(Arrays.toString(student[1]));
						//System.out.println(Arrays.toString(student[2]));
						//System.out.println(Arrays.toString(student[3]));
						//System.out.println(Arrays.toString(student[4]));
						//System.out.println();
						//--
						System.out.println();
						System.out.println("Student has been added successfully...");
						
					L5:	for (int x = 0; x < 3; x++){
							System.out.print("Do you want to add a new student? (y/n) : ");
							String yOrN = input.next();
							System.out.println();
							switch(yOrN){
								case("y"):
									clearConsole();
									addNewStudentWithMarks(student,totalMarks,avgMarks,rank); // executes from a new page with the header
									//continue L1;
								case("n"):
									clearConsole();
									homePage(student,totalMarks,avgMarks,rank);
								default: System.out.println("Invalid input...");
							}
						}
					}else{
						continue L2;
					}
				}
			}
			System.out.print("Invalid Student Id. Please enter correct Student ID....");
			System.out.println();
			System.out.println();
			continue L1;
		}
	}
	
	
	
	public static void addNewStudent(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank){

		//--------------------------Header--------------------------------
		
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t\t \033[1mADD NEW STUDENT \033[0m\t\t\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		Scanner input = new Scanner(System.in);
	
	L1:	for (int i = 0; i < student.length; i++){
			System.out.print("Enter Student ID\t: ");
			String studId = input.next();
			if (studId.indexOf("S") == 0){
			
			L2:	for (int j = 0; j < student.length; j++){
					if(studId.equals(student[j][0])){
						System.out.print("This student ID already exists...");
						System.out.println();
						continue L1;
					}else if((student[j][0]) == null){
						//---recheck----
						student[j][0] = studId;
						System.out.print("Enter Student Name\t: ");
						student[j][1] = input.next();
						//continue L1;
						
						//--
						System.out.println(Arrays.toString(student[0]));
						System.out.println(Arrays.toString(student[1]));
						System.out.println(Arrays.toString(student[2]));
						System.out.println(Arrays.toString(student[3]));
						System.out.println(Arrays.toString(student[4]));
						System.out.println();
						//--

						System.out.println();
						System.out.println("Student has been added successfully...");
						System.out.print("Do you want to add a new student? (y/n) : ");
						String yOrN = input.next();
						System.out.println();
						
						switch(yOrN){
							case("y"):
								clearConsole();
								addNewStudent(student,totalMarks,avgMarks,rank); //executes from a new page with the header
								//continue L1;
							case("n"):
								clearConsole();
								homePage(student,totalMarks,avgMarks,rank);
							//default: System.out.println("Invalid input...");				
						}
					}else{
						continue L2;
					}
				
				}	
			}else{
				System.out.print("Invalid Student ID, please enter correct Student ID...");
				System.out.println();
				continue L1;
			}
		}
	}
	
	public static void homePage(String[][] student, int[] totalMarks, double[] avgMarks, double[] rank ){
		
		//--------------------------Header--------------------------------
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println("|\t\t\t\t\t \033[1mWELCOME TO GDSE MARKS MANAGEMENT SYSTEM \033[0m\t\t\t\t\t|");
		for (int i = 0; i < 120; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
		//----------------------------------------------------------------
		Scanner input=new Scanner(System.in);
		
		System.out.print("[1] Add New Student\t\t\t\t");
		System.out.println("[2] Add New Student With Marks");
		System.out.print("[3] Add Marks\t\t\t\t\t");
		System.out.println("[4] Update Student Details");
		System.out.print("[5] Update Marks\t\t\t\t");
		System.out.println("[6] Delete Students");
		System.out.print("[7] Print Student Details\t\t\t");
		System.out.println("[8] Print Student Ranks");
		System.out.print("[9] Best in Programming Fundamentals\t\t");
		System.out.println("[10] Best in Database Management System");
		System.out.println();
		System.out.println();
	
		System.out.print("\033[1mEnter an option to continue > \033[0m");
		String option = input.next();
		
		clearConsole();
		switch(option){
			case("1")	: addNewStudent(student,totalMarks,avgMarks,rank);break;
			case("2")	: addNewStudentWithMarks(student,totalMarks,avgMarks,rank); break;
			case("3")	: addMarks(student,totalMarks,avgMarks,rank); break;
			case("4")	: updateStudentDetails(student,totalMarks,avgMarks,rank); break;
			case("5")	: updateMarks(student,totalMarks,avgMarks,rank); break;
			case("6")	: deleteStudent(student,totalMarks,avgMarks,rank); break;
			case("7")	: printStudentDetails(student,totalMarks,avgMarks,rank);break;
			case("8")	: printStudentRank(student,totalMarks,avgMarks,rank); break;
			case("9")	: findBestInPF(student,totalMarks,avgMarks,rank); break;
			case("10"): findBestInDBMS(student,totalMarks,avgMarks,rank); break;
			default	: System.out.println("Invalid option..."); break;
		}
		clearConsole();
	}
	
	public static void main(String args[]){
		String[][] student = new String[100][4];
		int[] totalMarks = new int[100];
		double[] avgMarks = new double[100];
		double[] rank = new double[100];
		homePage(student,totalMarks,avgMarks,rank);
	}
}

