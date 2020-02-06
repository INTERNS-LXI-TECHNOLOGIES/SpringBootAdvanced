package com.lxisoft.model;
import java.util.Comparator;
import com.lxisoft.domain.Contact;
/**
 *class to sort contacts by id
 */
public class SortById implements Comparator<Contact>
{
	/**
	 *to compare contact using id
	 *
	 *@param c1 contact 1
	 *@param c2 contact 2
	 *@return integer value
	 */
	public int compare(Contact c1,Contact c2)
	{
		int x=(c1.getContactId());
		int y=(c2.getContactId());
		return x-y;
	}
}