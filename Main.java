import java.util.*;
class Main{
	public static String [][]user=new String[1][2];
	public static String []lable={"loging page","WELCOME IJSE STOCK MANGEMENT SYSTEM"};
	public static String []icon={"Change the credentials","Suppier Manage","Stock mange","Log out","Exit the System"};
	public static Scanner input=new Scanner(System.in);
	public static void main(String args[]){
		user[0][0]="Danujav";
		user[0][1]="1234@";
		loging();
	}
	public static void loging(){
		System.out.printf("+-------------------------------------------------+%n");
		System.out.printf("%-20s"+"%s"+"%20s%n","|",lable[0],"|");
		System.out.printf("+-------------------------------------------------+%n");
		
		boolean flag=false;
		while(flag!=true){
			System.out.print("user name : ");
			String uname=input.next();
			if(uname.equals(user[0][0])){
				System.out.println();
				while(flag!=true){
				System.out.print("password : ");
				String pw=input.next();
				if(pw.equals(user[0][1])){
					flag=true;
					clearConsole();
					homepage();
					
				}
				else{
					System.out.println("incorrect password.try again");
					System.out.println();
				}
			}
		}
			else{
				System.out.println("incoreect user name.Try again");
				System.out.println();
			}
		}
		
	}
	
	private final static void clearConsole() {
	final String os = System.getProperty("os.name");
	try {
		if (os.equals("Linux")) {
		System.out.print("\033\143");
	} else if (os.equals("Windows")) {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	} else {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	} catch (final Exception e) {
	//handle the exception
	System.err.println(e.getMessage());
	}
	}
	public static void homepage(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-20s"+"%s"+"%20s%n","|",lable[1],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%s%d%s %s","[",1,"]",icon[0]);
		System.out.printf("%9s%d%s %s%n","[",2,"]",icon[1]);
		System.out.printf("%s%d%s %s","[",3,"]",icon[2]);
		System.out.printf("%20s%d%s %s%n","[",4,"]",icon[3]);
		System.out.printf("%s%d%s %s%n\n","[",5,"]",icon[4]);
		select();
	}
	public static void select(){
		System.out.print("Enter the option continue : ");
		int num=input.nextInt(); 
		clearConsole();  
		if(num==1){
			Change_the_credentials();
		}
		if(num==2){
			Suppier_Manage();
		}
		if(num==3){
			stock_Manage();
		}
		
		if(num==4){
			logout();
		}
		
		if(num==5){
			exit();
		}
	}
		public static String [] stock_page={"Manage the item categories","Add item","Get items supplier wise","view items","Rank items per unit price","home page"};
		public static void stock_Manage(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%34s%n","|",icon[2],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		System.out.printf("%s%d%s %-40s","[",1,"]",stock_page[0]);
		System.out.printf("%s%d%s %s%n","[",2,"]",stock_page[1]);
		System.out.printf("%s%d%s %-40s","[",3,"]",stock_page[2]);
		System.out.printf("%s%d%s %s%n","[",4,"]",stock_page[3]);
		System.out.printf("%s%d%s %-40s","[",5,"]",stock_page[4]);
		System.out.printf("%s%d%s %s%n\n","[",6,"]",stock_page[5]);
		select3();
		}
		public static void select3(){
			System.out.print("Enter an option to continue --> ");
			int num=input.nextInt();
			clearConsole();
			if(num==1){
				Manage_item_categories();
			}
			if(num==2){
				Add_item();
			}
			if(num==3){
				Get_items_supplier_wise();
			}
			if(num==4){
				view_items();
			}
			if(num==5){
				Rank_items_per_unit_price();
			}
				
			if(num==6){
				homepage();
			}
			
		}
		public static void Rank_items_per_unit_price(){
		System.out.printf("+-------------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%34s%n","|","Ranked Unit Price","|");
		System.out.printf("+-------------------------------------------------------------------------------+%n\n");
		System.out.println("\n");
		double []temp=sortArray(item);
		
		System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.printf("%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%n","|","SID","|","ICODE","|","DISC","|","PRICE","|","QTY","|","Cat","|");
		System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		for(int i=0;i<temp.length;i++){
			for(int j=0;j<item.length;j++){
				if(temp[i]==Double.parseDouble(item[j][4])){
					
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%n","|",item[j][0],"|",item[j][1],"|",item[j][3],"|",item[j][4],"|",item[j][5],"|",item[j][2],"|");
			System.out.printf("------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");                                
		}
		}
	}
		
		System.out.print("Do you want go home page(y/n) : ");
		char y=input.next().charAt(0);
		if(y=='y'||y=='Y'){
			clearConsole();
				homepage();
			}
			if(y=='n'||y=='N'){
				clearConsole();
				stock_Manage();
			}
	}
		public static double[] sortArray(String[][] item) {
			double []temp=new double[item.length];
			for(int i=0;i<item.length;i++){
				temp[i]=Double.parseDouble(item[i][4]);
			}
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = 0; j < item.length - 1; j++) {
				if(temp[j] > temp[j+1]) {
					double xr = temp[j];
					temp[j] = temp[j+1];
					temp[j+1] = xr;
				}	
			}
		}
		return temp;
	}


		public static void view_items(){
		System.out.printf("+------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%34s%n","|",stock_page[3],"|");
		System.out.printf("+------------------------------------------------------------------------+%n\n");
			
			System.out.println("\n");
			for(int i=0;i<item_category.length;i++){
			System.out.println(item_category[i]+" : ");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%n","|","SID","|","ICODE","|","DISC","|","PRICE","|","QTY","|");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------------+%n");
			for(int j=0;j<item.length;j++){
			if(item_category[i].equals(item[j][2])){
			
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%n","|",item[j][0],"|",item[j][1],"|",item[j][3],"|",item[j][4],"|",item[j][5],"|");
			System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------%n");                                
		}
	}
}
			System.out.print("Do you want to go stock manage page(y/n) :");
			char yo=input.next().charAt(0); 
			if(yo=='y'||yo=='Y'){
				clearConsole();
				stock_Manage();
			}
			if(yo=='n'||yo=='N'){
				clearConsole();
				homepage();
			}
}
			
			
		public static void Get_items_supplier_wise(){
			System.out.printf("+-------------------------------------------------------------------------------------+%n");
			System.out.printf("%-30s"+"%s"+"%34s%n","|",stock_page[2],"|");
			System.out.printf("+-------------------------------------------------------------------------------------+%n\n");
			boolean flag=false;
			l7: while(flag!=true){
				System.out.print("Enter supplier id : ");
				String id=input.next();
					for(int i=0;i<suppiers.length;i++){
						if(id.equals(suppiers[i][0])){
							System.out.println("supplier name : "+suppiers[i][1]);
							for(int k=0;k<item.length;k++){
								
							if(suppiers[i][0].equals(item[k][1])){
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%n","|","ITEM CODE","|","DISCRIPTION","|","UNIT PRICE","|","QTY ON HAND","|","CATEGORY","|");
			System.out.printf("+-----------------------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%-20s%-10s%n","|",item[k][1],"|",item[k][3],"|",item[k][4],"|",item[k][5],"|",item[k][2],"|");
			System.out.printf("------------------------------------------------------------------------------------------------------------------------------------------------%n");
			flag=true;
		}
				
		}
	}
	}

	if(flag==false){
	System.out.println("try try try !");
	continue l7;
	
	}
	System.out.print("search successfully!Do you want to another search(y/n) : ");
			
			char ui=input.next().charAt(0);
			if(ui=='y'||ui=='Y'){
				clearConsole();
				Get_items_supplier_wise();
			}
			if(ui=='n'||ui=='N'){
				clearConsole();
				stock_Manage();
			}
		}
		}
	
			
		public static String[][] item=new String[0][6];
		public static void Add_item(){
			System.out.printf("+----------------------------------------------------------------------+%n");
			System.out.printf("%-30s"+"%s"+"%34s%n","|",stock_page[1],"|");
			System.out.printf("+----------------------------------------------------------------------+%n\n");
			if(item_category.length==0){
				System.out.print("Oops!It seems that you don't have any item categories in the system....Do you want to add new item category?(y/n) : ");
				char tr=input.next().charAt(0);
				if(tr=='y'|tr=='Y'){
					clearConsole();
					add_new_item_category();
				}
				else if(tr=='n'|tr=='N'){
					clearConsole();
					stock_Manage();
				}
				else{
					System.out.println("wrong input!");
					clearConsole();
					Add_item();
				}
			}
			if(suppiers.length==0){
				System.out.print("Oops!It seems that you don't have any suppliers in the system....Do you want to add new item suppliersa?(y/n) : ");
				char tr=input.next().charAt(0);
				if(tr=='y'||tr=='Y'){
					clearConsole();
					addsuppiers();
				}
				else if(tr=='n'||tr=='N'){
					clearConsole();
					stock_Manage();
				}
				else{
					System.out.println("wrong input!");
					clearConsole();
					Add_item();
				}
			}
			boolean flag=false;
			item=grow4();
			l6: while(flag!=true){
				System.out.print("Item code : ");
				String ic=input.next();
				for(int i=0;i<item.length;i++){
				
					if(ic.equals(item[i][0])){
						System.out.println("Item code already added!try again..");
						
						continue l6;
						
					}
				}
				if(flag==false){
					item[item.length-1][0]=ic;
					
					flag=true;
					System.out.println("\nSupplier list :");
					suppierlist();
					System.out.print("Enter the supplier number :");
					int x=input.nextInt();
					item[item.length-1][1]=suppiers[x-1][0];
					System.out.println();
					System.out.println("Item categories : ");
					Item_categories_list();
					System.out.print("Enter the category number : ");
					int py=input.nextInt();
					item[item.length-1][2]=item_category[py-1];
					System.out.print("Discription : ");
					String discription=input.next();
					item[item.length-1][3]=discription;
					System.out.print("unit price : ");
					String price=input.next();
					item[item.length-1][4]=price;
					System.out.print("Qty on hand : ");
					String qty=input.next();
					item[item.length-1][5]=qty;
					System.out.println();
					System.out.print("added successfully!Do you want add another item(y/n) ");
					char in=input.next().charAt(0);
					if(in=='y'||in=='Y'){
						clearConsole();
						Add_item();
					}
					if(in=='n'||in=='N'){
						clearConsole();
						stock_Manage();
					}
				}
			}
		}
		public static void Item_categories_list(){
			System.out.printf("+-----------------------------------------------------------+%n");
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%n","|","#","|","Category name","|");
			System.out.printf("+------------------------------------------------------------+%n");
			for(int i=0;i<item_category.length;i++){
			System.out.printf("%-10s%-20d%-10s%-20s%-10s%n","|",(i+1),"|",item_category[i],"|");
			System.out.printf("--------------------------------------------------------------%n");
		}
	}
			
		public static void suppierlist(){
			System.out.printf("+-----------------------------------------------------------------------------------------+%n");
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%-20s%-10s%n","|","#","|","suppier name","|","suppier id","|");
			System.out.printf("+-----------------------------------------------------------------------------------------+%n");
		for(int i=0;i<suppiers.length;i++){
			System.out.printf("%-10s%-20d%-10s%-20s%-10s%-20s%-10s%n","|",(i+1),"|",suppiers[i][0],"|",suppiers[i][1],"|");
			System.out.printf("-------------------------------------------------------------------------------------------%n");
		}
	}
		public static String [][] grow4(){
			String [][]temp=new String[item.length+1][6];
			for(int i=0;i<item.length;i++){
				for(int j=0;j<item[i].length;j++){
					temp[i][j]=item[i][j];
				}
			}return temp;
		}
			
		public static String[]Mic_page={"add new item category","delete item category","update item category","stock management"};
		public static void Manage_item_categories(){
			System.out.printf("+---------------------------------------------------------------------------+%n");
		System.out.printf("%-20s"+"%s"+"%31s%n","|",stock_page[0],"|");
		System.out.printf("+---------------------------------------------------------------------------+%n\n");
		System.out.printf("%s%d%s %-40s","[",1,"]",Mic_page[0]);
		System.out.printf("%s%d%s %s%n","[",2,"]",Mic_page[1]);
		System.out.printf("%s%d%s %-40s","[",3,"]",Mic_page[2]);
		System.out.printf("%s%d%s %s%n","[",4,"]",Mic_page[3]);
		System.out.println();
		select4();
	}
		public static void select4(){
			System.out.print("Enter an option to continue --> ");
			int num=input.nextInt();
			clearConsole();
			if(num==1){
				add_new_item_category();
			}
			if(num==2){
				delete_item_category();
			}
			if(num==3){
				update_item_categary();
			}
			if(num==4){
				stock_Manage();
			}
				
		}
		public static void update_item_categary(){
			System.out.printf("+-------------------------------------------------------------------+%n");
			System.out.printf("%-20s"+"%s"+"%29s%n","|","update item category","|");
			System.out.printf("+-------------------------------------------------------------------+%n\n");
			boolean flag=false;
			l7: while(flag!=true){
				System.out.print("item category : ");
				String itme=input.next();
				for(int i=0;i<item_category.length;i++){
					if(itme.equals(item_category[i])){
						System.out.print("enter the new item category : ");
						String item_c=input.next();
						item_category[i]=item_c;
						flag=true;
						break;
					}
				}
				if(flag==false){
					System.out.println("can't find suppier id.try again");
					continue l7;
				}
				System.out.print("Update successfully!Do you want to update another suppier(y/n) ?");
				char dp=input.next().charAt(0);
				if(dp=='y'||dp=='Y'){
				clearConsole();
				update_item_categary();
			}
			if(dp=='n'||dp=='N'){
				clearConsole();
				stock_Manage();
			}
		}
	}
			
		public static void delete_item_category(){
			System.out.printf("+-------------------------------------------------------------------+%n");
			System.out.printf("%-20s"+"%s"+"%29s%n","|","delete item category","|");
			System.out.printf("+-------------------------------------------------------------------+%n\n");
			boolean flag=false;
			l6: while(flag!=true){
				System.out.print("item category : ");
				String itme=input.next();
				for(int i=0;i<item_category.length;i++){
					if(itme.equals(item_category[i])){
						int x=i;
						item_category=growd(x);
						flag=true;
					}
				}
				if(flag==false){
				System.out.println("can't find item category..try again!");
				continue l6;
			}
			System.out.print("Delete successfully.Do you want to delete another item category(y/n) : ");
			char ox=input.next().charAt(0);
			if(ox=='y'||ox=='Y'){
				clearConsole();
				delete_item_category();
			}
			if(ox=='n'||ox=='N'){
				clearConsole();
				stock_Manage();
			}
		}
		}
			
			public static String[] growd(int x){    
				String []temp=new String[item_category.length-1];
				for(int i=0,j=0;i<item_category.length;i++){
					if(x!=i){
						temp[j++]=item_category[i];
					}
				}
				return temp;
			}
				
				
		public static String[] item_category=new String[0];
		public static void add_new_item_category(){
			System.out.printf("+---------------------------------------------------------------------+%n");
		System.out.printf("%-20s"+"%s"+"%34s%n","|","add item category","|");
		System.out.printf("+---------------------------------------------------------------------+%n\n");
		
		String []duplicate3=duplicate3(item_category);
		item_category=grow3();
		boolean flag=false;
		l4: while(flag!=true){
		System.out.print("Enter the new item category : ");
		String item=input.next();
		for(int i=0;i<item_category.length;i++){
		if(item.equals(duplicate3[i])){
			
			System.out.println("allready exists.try another item category! ");
		continue l4;
		}
		}
		item_category[item_category.length-1]=item;  
		System.out.print("added successfully!.Do you want to add anothr item category(y/n) : ");
		char bh=input.next().charAt(0);
		if(bh=='y'||bh=='Y'){
			clearConsole();
			add_new_item_category();
		}
		if(bh=='n'||bh=='N'){
			flag=true;
			clearConsole();
			stock_Manage();
		}
	}
	}
	
		public static String[] grow3(){
			String []temp=new String[item_category.length+1];
			for(int i=0;i<item_category.length;i++){
				temp[i]=item_category[i];
			}
			return temp;
		}
		public static String[] duplicate3(String[] item_category){
			String []temp=new String[item_category.length+11];
			for(int i=0;i<item_category.length;i++){
				temp[i]=item_category[i];
			}return temp;
		}
		
		public static String [] suppier_page={"add suppier","update suppier","delete suppier","view suppier","search suppier","home page"};
		public static void Suppier_Manage(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",icon[1],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		System.out.printf("%s%d%s %-40s","[",1,"]",suppier_page[0]);
		System.out.printf("%s%d%s %s%n","[",2,"]",suppier_page[1]);
		System.out.printf("%s%d%s %-40s","[",3,"]",suppier_page[2]);
		System.out.printf("%s%d%s %s%n","[",4,"]",suppier_page[3]);
		System.out.printf("%s%d%s %-40s","[",5,"]",suppier_page[4]);
		System.out.printf("%s%d%s %s%n\n","[",6,"]",suppier_page[5]);
		select2();
		}
		public static void select2(){
			System.out.print("Enter an option to continue --> ");
			int num=input.nextInt();
			clearConsole();
			if(num==1){
				addsuppiers();
			}
			if(num==2){
				update_suppiers();
			}
			if(num==3){
				delete_suppiers();
			}
			if(num==4){
				view_suppiers();
			}
			if(num==5){
				search_suppiers();
			}
			if(num==6){
				homepage();
			}
			
		}
		
		public static void search_suppiers(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[3],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		boolean flag =false;
		l3: while(flag!=true){
			System.out.print("suppier id : ");
			String id=input.next();
			for(int i=0;i<suppiers.length;i++){
				if(id.equals(suppiers[i][0])){
					System.out.println("suppier name : "+suppiers[i][1]);
					flag=true;
					break;
				}
				
			}
			if(flag==false){
				System.out.println("can't find suppier id!.try again .");
				continue l3;
			}
			System.out.print("added successfully!.Do you want to add another find(y/n) : ");
			char ss=input.next().charAt(0);
			if(ss=='y'||ss=='Y'){
				clearConsole();
				search_suppiers();
			}
			if(ss=='n'||ss=='N'){
				clearConsole();
				Suppier_Manage();
			}
		}
	}
		public static void view_suppiers(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[3],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		System.out.printf("+-----------------------------------------------------------+%n");
		System.out.printf("%-10s%-20s%-10s%-20s%-10s%n","|","suppier name","|","suppier id","|");
		System.out.printf("+-----------------------------------------------------------+%n");
		for(int i=0;i<suppiers.length;i++){
			System.out.printf("%-10s%-20s%-10s%-20s%-10s%n","|",suppiers[i][0],"|",suppiers[i][1],"|");
			System.out.printf("-------------------------------------------------------------%n");
		}
		System.out.print("Do you want to go suppier manage page(y/n) : ");
		char oy=input.next().charAt(0);
		if(oy=='y'||oy=='Y'){
			clearConsole();
			Suppier_Manage();
		}
		if(oy=='n'||oy=='N'){
			clearConsole();
			view_suppiers();
		}
	}
		public static void delete_suppiers(){
			System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[2],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
		boolean flag=false;
		l2: while(flag!=true){
			System.out.print("suppier id : ");
			String id=input.next();
			for(int i=0;i<suppiers.length;i++){
				if(id.equals(suppiers[i][0])){
					int x=i;
					suppiers=grow2(x);
					flag=true;
				}
			}
			if(flag==false){
				System.out.println("can't find suppier id..try again!");
				continue l2;
			}
			System.out.print("Delete successfully.Do you want to delete another suppiers(y/n) : ");
			char ox=input.next().charAt(0);
			if(ox=='y'||ox=='Y'){
				clearConsole();
				delete_suppiers();
			}
			if(ox=='n'||ox=='N'){
				clearConsole();
				Suppier_Manage();
			}
		}
		}
		public static String[][] grow2(int x){
			String temp2[][]=new String[suppiers.length-1][2];
			for(int i=0,j=0;i<suppiers.length;i++){
					if(x!=i){
					temp2[j++]=suppiers[i];
				}
			}
			return temp2;
		
	}
		public static void update_suppiers(){
		System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[1],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n\n");
			
			boolean flag=false;
			l1: while(flag!=true){
			System.out.print("suppier id : ");
			String id=input.next();
			for(int i=0;i<suppiers.length;i++){
				if(id.equals(suppiers[i][0])){
					System.out.println("suppier name :"+suppiers[i][1]+"\n");
					System.out.print("Enter the new suppier name : ");
					String name=input.next();
					suppiers[i][1]=name;
					flag=true;                              //else ekak dala mehem else{System.out.println("can't find suppier id.try again");
		                                                           //continue l1; } kiyala danna ba....
					break;
				}
			}
			if(flag==false){                                //ehema danna bari nisa if ekak dala mehema aran thiyenne
					System.out.println("can't find suppier id.try again");
					continue l1;
				}
				
		System.out.print("Update successfully!Do you want to update another suppier(y/n) ?");
			char op=input.next().charAt(0);
			if(op=='y'||op=='Y'){
				clearConsole();
				update_suppiers();
			}
			if(op=='n'||op=='N'){
				clearConsole();
				Suppier_Manage();
			}
		}
	}
		public static String [][]suppiers=new String[0][2];
		public static void addsuppiers(){
			System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%31s%n","|",suppier_page[0],"|");
		System.out
		.printf("+-------------------------------------------------------------------------+%n\n");
		String []duplicate=duplicate(suppiers);
		suppiers=grow(suppiers);
		boolean flag=false;
		l1: while(flag!=true){
		System.out.print("suppier id : ");
		String s_id=input.next();
		for(int i=0;i<suppiers.length;i++){
		if(s_id.equals(duplicate[i])){
		System.out.println("allready exists.try another suppier id! ");
		continue l1;
	}
	
}
		suppiers[suppiers.length-1][0]=s_id;
		System.out.print("suppier name : ");
		suppiers[suppiers.length-1][1]=input.next();
		
		System.out.print("Added successfully!Do you want to add another suppier?(y/n) : ");
		char op=input.next().charAt(0);
		if(op=='y'||op=='Y'){
			clearConsole();
			addsuppiers();
		}
		if(op=='n'||op=='N'){
			flag=true;
			clearConsole();
			Suppier_Manage();
		}
	}
}
	
	public static String[] duplicate(String [][]suppiers){
		String []temp=new String[suppiers.length+1];
		for(int i=0;i<suppiers.length;i++){
			temp[i]=suppiers[i][0];
		}
		return temp;
	}
	public static String[][] grow(String[][]suppiers){
		String [][]temp=new String[suppiers.length+1][2];
		for(int i=0;i<suppiers.length;i++){
			temp[i][0]=suppiers[i][0];
			temp[i][1]=suppiers[i][1];
		}
		return temp;
	}
	
		public static void exit(){
			System.exit(0);
		}
		
		public static void logout(){
			loging();
		}
		
		public static void Change_the_credentials(){
		
			System.out.printf("+-------------------------------------------------------------------------+%n");
		System.out.printf("%-30s"+"%s"+"%23s%n","|",icon[0],"|");
		System.out.printf("+-------------------------------------------------------------------------+%n");
		boolean flag=false;
		while(flag!=true){
			System.out.print("please Enter the user name to verify it's you : ");
			String vname=input.next();
			if(vname.equals(user[0][0])){
				System.out.println("Heyy "+vname);
				while(flag!=true){
					System.out.print(user[0][0]+" Enter your current password : ");
					String vpw=input.next();
					if(vpw.equals(user[0][1])){
						
						System.out.println();
						while(flag!=true){
						System.out.print("Enter your current password :");
						String cpw=input.next();
						if(cpw.equals(user[0][1])){
							flag=true;
						System.out.print("Enter your new password : ");
						String newpw=input.next();
						user[0][1]=newpw;
						System.out.print("password changed successfully!");
						System.out.print("Do you want go home page(y/n) : ");
						char op=input.next().charAt(0);
						if(op=='y'){
							clearConsole();
							homepage();
							System.out.println("\n");
							
							select();
						
						}
					}
					else{System.out.println("try try");}
				}
			}
					else{
						System.out.println("Incorrect password.try again\n");
					}
				}
			}
			else{System.out.println("Invalid user name.try again\n");
			}
		}
	}
	
	}
