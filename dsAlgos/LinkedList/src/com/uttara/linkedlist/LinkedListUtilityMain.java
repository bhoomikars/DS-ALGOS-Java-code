package com.uttara.linkedlist;

public class LinkedListUtilityMain {
	
	public static void main(String[] args) {
		
		LinkedList linkedListOne = new LinkedList();
		linkedListOne.insert(4);
		linkedListOne.insert(8);
		linkedListOne.insert(17);
		linkedListOne.insert(23);
		linkedListOne.insert(47);
		linkedListOne.insert(69);
		linkedListOne.insert(74);
		System.out.println("First LL : ");
		linkedListOne.traverse();
		
		
		LinkedList linkedListtwo = new LinkedList();
		linkedListtwo.insert(5);
		linkedListtwo.insert(7);
		linkedListtwo.insert(18);
		linkedListtwo.insert(22);
		linkedListtwo.insert(45);
		linkedListtwo.insert(72);
		linkedListtwo.insert(89);
		linkedListtwo.insert(92);
		System.out.println("Second LL : ");
		linkedListtwo.traverse();
		
		
		LinkedList mergedListOne = LinkedListUtility.mergeSortListIteration(linkedListOne, linkedListtwo);
		System.out.println("Merged list (Iterative): ");
		mergedListOne.traverse();
		
		LinkedList linkedListThree = new LinkedList();
		linkedListThree.insert(4);
		linkedListThree.insert(8);
		linkedListThree.insert(17);
		linkedListThree.insert(23);
		linkedListThree.insert(47);
		linkedListThree.insert(69);
		linkedListThree.insert(74);
		System.out.println("Third LL : ");
		linkedListThree.traverse();
		
		
		LinkedList linkedListFour = new LinkedList();
		linkedListFour.insert(5);
		linkedListFour.insert(7);
		linkedListFour.insert(18);
		linkedListFour.insert(22);
		linkedListFour.insert(45);
		linkedListFour.insert(72);
		linkedListFour.insert(89);
		linkedListFour.insert(92);
		System.out.println("Fourth LL : " );
		linkedListFour.traverse();
		
		
		LinkedList mergedListTwo = LinkedListUtility.mergeSortedListsRecursive(linkedListThree, linkedListFour);
		System.out.println("Merged List (Recursive) : " );
		mergedListTwo.traverse();
		
		LinkedList linkedListFive = new LinkedList();
		linkedListFive.insert(4);
		linkedListFive.insert(8);
		linkedListFive.insert(9);
		linkedListFive.insert(5);
		System.out.println("Fifth LL : " );
		linkedListFive.traverse();
		
		LinkedList linkedListSix = new LinkedList();
		//linkedListSix.insert(7);
		linkedListSix.insert(8);
		linkedListSix.insert(2);
		linkedListSix.insert(6);
		System.out.println("Sixth LL : " );
		linkedListSix.traverse();
		
		LinkedList sumList = LinkedListUtility.addLists(linkedListFive, linkedListSix);
		System.out.println("Reverse Sum List : ");
		sumList.traverse();
		
		LinkedList forwardSumList = LinkedListUtility.addListsForward(linkedListFive, linkedListSix);
		System.out.println("Forward Sum List : ");
		forwardSumList.traverse();
		
		LinkedList linkedListSeven = new LinkedList();
		linkedListSeven.insert(50);
		linkedListSeven.insert(32);
		linkedListSeven.insert(85);
		linkedListSeven.insert(27);
		linkedListSeven.insert(56);
		linkedListSeven.insert(98);
		linkedListSeven.insert(12);
		linkedListSeven.insert(18);
		linkedListSeven.insert(5);
		linkedListSeven.insert(2);
		System.out.println("List Before Partition : ");
		linkedListSeven.traverse();
		System.out.println("List After Partition : ");
		LinkedList partitionedList = LinkedListUtility.partition(linkedListSeven, 32);
		partitionedList.traverse();
		
		LinkedList linkedListPalindrome = new LinkedList();
		linkedListPalindrome.insert(2);
		linkedListPalindrome.insert(4);
		linkedListPalindrome.insert(6);
		linkedListPalindrome.insert(8);
		linkedListPalindrome.insert(10);
		linkedListPalindrome.insert(6);
		linkedListPalindrome.insert(4);
		linkedListPalindrome.insert(2);
		System.out.println(" Palindrome List : ");
		linkedListPalindrome.traverse();
		
		System.out.println("Is Palindrome : " +LinkedListUtility.isPalindrome(linkedListPalindrome));
		
		LinkedList palindromeList = new LinkedList();
		createPalindromeList(palindromeList, 5);
		//System.out.println(" Palindrome List : ");
		//palindromeList.traverse();
		
		LinkedList pList = new LinkedList();
		createPalindromeList(pList, 10);
		System.out.println(" Palindrome List : ");
		pList.traverse();
		System.out.println(" Is Palindrome : " +LinkedListUtility.isPalindrome(pList));
		
		System.out.println("");
		
	}
	
	public static void createPalindromeList(LinkedList list, int data) {
		if(data==0) {
			list.insert(5);
			return;
		}
		else {
			
			data--;
			list.insert(data);
			createPalindromeList(list, data);
			list.insert(data);
		}
	}

	
}
