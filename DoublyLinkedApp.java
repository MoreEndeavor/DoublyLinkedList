class Link
{
	public long dData;
	public Link next;
	public Link previous;
	//-------------------
	public Link(long d)
	{
		dData = d;
	}
	//-------------------
	public void displayLink()  //display this link;
	{
		System.out.print(dData + " ");
	}
}
//////////////////////////////////////////
class DoublyLinkedList
{
	private Link first;
	private Link last;
	//----------------------
	public DoublyLinkedList()
	{
		first = null;
		last = null;
	}
	//----------------------
	public boolean isEmpty()
	{
		return first == null;
	}
	//---------------------
	public void insertFirst(long dd)
	{
		Link newLink = new Link(dd);

		if(isEmpty())
		{
			last = newLink;
		}
		else
		{
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;

		/*  This part is designed by me, I may right! 
		if(isEmpty())
		{
			first = newLink;
			last = newLink;
		}
		else
		{
			first.previous = newLink;
			newLink.next = first;
			first = newLink;
		}*/
	}
	//--------------------
	public void insertLast(long dd) //by me!
	{
		Link newLink = new Link(dd);
		if(isEmpty())
		{
			first = newLink;
			last = newLink;
		}
		else
		{
			last.next = newLink;
			newLink.previous = last;
			last = newLink;
		}
	}
	//------------------------------------------by me!
	public Link deleteFirst()
	{
		Link temp = first;    // what I designed support emtpy list
		if(first == null)	 // an empty list
		{
			System.out.println("Your list is an empty one, nothing to delete");
			return null;
		}
		if(first.next == null) //just one item is the list
		{
			last = null;
			first = null;
		}
		else
		{
			first.next.previous = null;
			first = first.next;
		}
		return temp;
	}
	//-------------------------------------------
	public Link deleteLast()
	{
		Link temp = last;	//save the last one !  what I designed support emtpy list
		if(last == null)	//an empty list
		{
			System.out.println("Your list is an empty one, nothing to delete");
			return null;
		}
		if(last.previous == null)
		{
			last = null;
			first = null;
		}
		else
		{
			last.previous.next = null;
			last = last.previous;
		}
		return temp;
	}
	//-------------------------------------------
	public void insertAfter(long key, long dd)  ////by me! make sure the "key" is already in your list;
	{
		Link current = first;
		Link temp = null;


		if(current==null) 	//the list is an empty one!
		{
			System.out.println("Your list is am empty one, please insert something first");
			return;
		}
	    else
	    {
		    while(current.dData!=key && current!=last)
		    {
			    current = current.next;
		    }
	    }

	    Link newLink = new Link(dd);
	    if(current==first)
	    {
	    	temp = current.next;	//these five lins codes can be written just once!
	    	current.next = newLink;
	    	newLink.next = temp;
	    	temp.previous = newLink;
	    	newLink.previous = current;
	    }
	    else if(current==last)
	    {
	    	if (current.dData!=key) {
	    		System.out.println("Cannot find the item according the key you give!");
	    		return ;
	    	}
	    	newLink.previous = current;
	    	current.next = newLink;
	    	last = newLink;
	    }
	    else
	    {
	    	temp = current.next;
	    	current.next = newLink;
	    	newLink.next = temp;
	    	temp.previous = newLink;
	    	newLink.previous = current;
	    }
	}
	//-------------------------------------------
	public Link deleteKey(long key)
	{
		Link current = first;
		Link currentNext = null;

		if(first==null)
		{
			System.out.println("You have nothing to delete, your list is an empty one!");
			return null;
		}
		else
		{
			while(current.dData!=key)
		    {
			    current = current.next;
			    if(current==null)
			    {
			    	System.out.println("You don't have the item in your list");
			    	return null;
			    }
		    }
		}

		if(current==first)  //support to delete the first item
		{
			current.next.previous = null;
			first = current.next;
			return current;
		}

		if(current==last)
		{
			current.previous.next = null;
			last = current.previous;
			return current;
		}
		else
		{
			current.previous.next = current.next;
			current.next.previous = current.previous;	//what I first wrote is :current.next = current.previous;
			return current;
		}

	}
	//--------------------------------------------
	public void displayForward()
	{
		System.out.print("List (first-->last): ");
		Link current = first;
		if(current==null)
		{
			System.out.print("empty list");
		}
		while(current!=null) //assume non-empty list
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	//---------------------------------------------
	public void displayBackword()
	{
		Link current = last;
		System.out.print("List (last-->first): ");
		if(current==null)
		{
			System.out.print("empty list");
		}
		while(current!=null)
		{
			current.displayLink();
			current = current.previous;
		}
		System.out.println();
	}

}
//-----------------------------------------------------
public class DoublyLinkedApp
{
	public static void main(String[] args)
	{
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertFirst(80);
		list.insertFirst(70);
		list.insertFirst(60);
		list.insertLast(21);
		list.insertLast(22);
		list.insertLast(23);
		list.displayForward();
		list.displayBackword();
		System.out.println();	//leave a line to see the result clearly!


	    System.out.println("when I insert 564 after the item 12 , the list becomes: ");
		list.insertAfter(70,564);
		list.displayForward();
		list.displayBackword();
		System.out.println();	//leave a line to see the result clearly!

        System.out.println("when I delete the item 21 and 22 form the list, it becomes: ");
        list.deleteKey(21);
        list.deleteKey(22);
        list.displayForward();
        list.displayBackword();
   	}
}	
