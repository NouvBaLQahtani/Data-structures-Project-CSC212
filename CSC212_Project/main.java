package CSC212_EProject;

import java.util.Scanner;

public class main {

	static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {

		//--Create an BT object of type String--
		BT<Character> maze = new BT<Character>();
		
		//--Insert all nodes Root, LeftChild, and RightChild--
		maze.insert(Relative.Root, 0, 'B');
		maze.insert(Relative.LeftChild, 1, 'S');
		maze.insert(Relative.LeftChild, 2, 'S');
		maze.insert(Relative.LeftChild, 3, 'S');
		
		maze.find(Relative.Root);
		
		maze.insert(Relative.RightChild, 4, 'T');
		maze.insert(Relative.RightChild, 15, 'S');
		maze.insert(Relative.RightChild, 16, 'S');
		maze.insert(Relative.RightChild, 17, 'X');

		
		maze.find(Relative.Root);
		maze.find(Relative.RightChild);

		
		maze.insert(Relative.LeftChild, 5, 'T');
		maze.insert(Relative.LeftChild, 6, 'S');
		maze.insert(Relative.LeftChild, 7, 'S');

		maze.find(Relative.Parent);
		maze.find(Relative.Parent);
		
		maze.insert(Relative.RightChild, 12, 'T');
		maze.insert(Relative.RightChild, 13, 'S');
		maze.insert(Relative.LeftChild, 14, 'T');
		
		maze.find(Relative.Parent);
		maze.find(Relative.Parent);
		maze.find(Relative.Parent);
		maze.find(Relative.LeftChild);
		
		maze.insert(Relative.RightChild, 8, 'T');
		maze.insert(Relative.LeftChild, 9, 'T');
		maze.insert(Relative.RightChild, 10, 'T');
		maze.insert(Relative.RightChild, 11, 'X');
		
		
		maze.find(Relative.Root);
		maze.find(Relative.RightChild);
		maze.find(Relative.LeftChild);


		//--Go back to the Root node--
		maze.find(Relative.Root);

		//--Display the menu--
		int number;
		do {
			
			//--Read the number of the desired method--
			System.out.println("Enter the number of method you want to use or (0) to exit: ");
			System.out.println("(1) follow");
			System.out.println("(2) escape");
			System.out.println("(3) short");

			number = read.nextInt();
			
			//--Switch the entered number to the appropriate method--
			switch(number) {
			
			case 1:
				//--Read the parameters of method follow from the user--
				System.out.print("Enter a key from 0 - 17 to start with: ");
				int key = read.nextInt();
				
				while(!maze.findKey(maze.root, key, false)) {
					
					System.out.println("The key isn't found");
					System.out.print("Enter a key from 0 - 17 to start with: ");
					key = read.nextInt();
				}
				
				System.out.print("Enter the path in the format: Y-Y-Y where Y may B, S, or T: ");
				String path = read.next();
				
				while(path.length()==1) {
					System.out.print("Incorrect path, please enter the path in the format: Y-Y-Y where Y may B, S, or T: ");
					path = read.next();
				}
					
				if(maze.follow(maze.current, path))
					System.out.print("The path is valid");
				else
					System.out.print("Invalid path");
				System.out.println();
				
				break;
				
			case 2:
				System.out.print("Enter a key from 0 - 17 to start with: "); 
				int key2 = read.nextInt();
				while(!maze.findKey(maze.root, key2, false)) {
					
					System.out.println("The key isn't found");
					System.out.print("Enter a key from 0 - 17 to start with: ");
					key2 = read.nextInt();
				}
				if(maze.escape(maze.current))
					System.out.print("There is an Exit Found Starting From The Node That Has The Key Number " + key2 );
				else
					System.out.print("There is No Exit Found Starting From The Node That Has The Key Number " + key2 );
				System.out.println();
				
				break;
				
			case 3:
				String ShortPath = maze.Short();
		        System.out.println("The Shorest path to reach the escape is "+ ShortPath);
				break;
			}

		}while(number != 0);
		
		
		


	}

}