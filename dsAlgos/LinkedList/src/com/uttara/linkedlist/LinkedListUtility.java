package com.uttara.linkedlist;

public class LinkedListUtility extends LinkedList {
	


	public static LinkedList mergeSortListIteration(LinkedList linkedListOne,
				LinkedList linkedListtwo) {
			// TODO Auto-generated method stub
			return new LinkedList(mergeSortListIteration(linkedListOne.getHead(), linkedListtwo.getHead()));
		}
	
	private static Node mergeSortListIteration(Node nodeA, Node nodeB) {
			 Node mergedNode ;
			 Node headNode ;      
	
			if (nodeA == null) {
			    return nodeB;
			  } 
			  if (nodeB == null) {
			    return nodeA;
			  }     
	
	
			if ( nodeA.getData() < nodeB.getData()) {
			    mergedNode = nodeA;
			    nodeA = nodeA.getNext();
			}
			else {
			    mergedNode = nodeB;
			    nodeB = nodeB.getNext();
			}
	
			headNode = mergedNode; 
	
			while (nodeA != null && nodeB != null) {           
	
			    if ( nodeA.getData() < nodeB.getData()) {               
			        mergedNode.setNext(nodeA);
			        nodeA = nodeA.getNext();
			    }
			    else {
			        mergedNode.setNext(nodeB);
			        nodeB = nodeB.getNext();                
			    }       
			    mergedNode = mergedNode.getNext();
			}
	
			if (nodeA != null) {
			    mergedNode.setNext(nodeA);
			}
	
			if (nodeB != null) {
			    mergedNode.setNext(nodeB);
			}       
			return headNode;
		}
		
	public static LinkedList mergeSortedListsRecursive(LinkedList linkedListOne,
				LinkedList linkedListTwo) {
			// TODO Auto-generated method stub
			return new LinkedList(mergeSortedListsRecursive(linkedListOne.getHead(), linkedListTwo.getHead()));
		}
	
	
	private static Node mergeSortedListsRecursive(Node nodeA, Node nodeB) {
		Node mergeNode = null;
		if(nodeA==null  && nodeB==null) {
			return null;
		}
		if(nodeA==null) {
			return nodeB;
		}
		else if(nodeB ==null) {
			return nodeA;
		}
		else {
			if(nodeA.getData() < nodeB.getData()) {
				mergeNode = nodeA;
				mergeNode.setNext(mergeSortedListsRecursive(nodeA.getNext(), nodeB));
			}
			else {
				mergeNode = nodeB;
				mergeNode.setNext(mergeSortedListsRecursive(nodeA, nodeB.getNext()));
			}
		}
	return mergeNode;
	}
	

	
	public static LinkedList addLists(LinkedList listOne, LinkedList listTwo) {
		return new LinkedList(addLists(listOne.getHead(), listTwo.getHead(), 0));
	}
	
	
	private  static Node addLists(Node first, Node second, int carry) {
		if (first == null && second == null && carry == 0) {
	         return null;
		}
		
		Node result = new Node(carry);
		int value = carry;
		if (first != null) {
			value += first.getData();
		}
		if (second != null) {
			value += second.getData();
		}
		result.setData(value % 10);
		if (first != null || second != null || value >= 10) {
			Node more = addLists(first == null ? null : first.getNext(), 
										   second == null ? null : second.getNext(), 
										   value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		return result;
	}


	public static LinkedList addListsForward(LinkedList l1, LinkedList l2) {
		int len1 = l1.getSize();
		int len2 = l2.getSize();
		if (len1 < len2) {
			l1= padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		NodeSum sum = addListsHelper(l1.getHead(), l2.getHead());
		if (sum.getCarry() == 0) {
			return new LinkedList(sum.getDataNode());
		} else {
			Node result = insertBefore(sum.getDataNode(), sum.getCarry());
			return new LinkedList(result);
		}
	}	
	
	private static LinkedList padList(LinkedList l, int padding) {
		Node head = l.getHead();
		for (int i = 0; i < padding; i++) {
			Node n = new Node(0);
			n.setNext(head);
			head = n;
		}
		return new LinkedList(head);
	}
	
	private static NodeSum addListsHelper(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			NodeSum sum = new NodeSum(null,0);
			return sum;
		}
		NodeSum full_sum = addListsHelper(l1.getNext(), l2.getNext());
		int val = full_sum.getCarry() + l1.getData() + l2.getData();
		Node result = insertBefore(full_sum.getDataNode(), val % 10);
		full_sum.setDataNode(result);
		full_sum.setCarry(val / 10);
		return full_sum;
	}
	
	private static Node insertBefore(Node list, int data) {
		Node node = new Node(data);
		if (list != null) {
			node.setNext(list);
		}
		return node;
	}
	
	
	public static LinkedList partition(LinkedList list, int data) {
		
		return new LinkedList(partition(list.getHead(), data));
	}
 
	private static Node partition(Node node, int data) {
		Node beforeStart = null;
		Node beforeEnd = null;
		Node afterStart = null;
		Node afterEnd = null;
		
		/* Partition list */
		while (node != null) {
			Node next = node.getNext();
			node.setNext(null);
			if (node.getData() < data) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.setNext(node);
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.setNext(node);
					afterEnd = node;
				}
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.setNext(afterStart);
		return beforeStart;
	}

	public static boolean isPalindrome(LinkedList list) {
		return isPalindromeRecurse(list.getHead(), list.getSize()).isPalindrome();
	}
	
	private static  ResultNode isPalindromeRecurse(Node head, int length) {
		if (head == null || length == 0) {
			return new ResultNode(null, true);
		} else if (length == 1) {
			return new ResultNode(head.getNext(), true);
		} else if (length == 2) {
			return new ResultNode(head.getNext().getNext(), head.getData() == head.getNext().getData());
		}
		ResultNode res = isPalindromeRecurse(head.getNext(), length - 2);
		if (!res.isPalindrome() || res.getNode() == null) {
			return res; 
		} else {
			res.setPalindrome(head.getData() == res.getNode().getData());
			res.setNode(res.getNode().getNext());
			return res;
		}
	}




}
